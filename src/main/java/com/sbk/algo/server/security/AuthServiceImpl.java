package com.sbk.algo.server.security;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sbk.algo.client.service.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("authService")
@Transactional
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    public String retrieveUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            System.out.println("Not logged in");
            return null;
        } else {
            return (String) authentication.getPrincipal();
        }
    }

    @Override
    public void authenticate(String login, String password) {
        User user = new User(login, password, true, true, true, true, new ArrayList<GrantedAuthority>());
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
                user.getAuthorities());
        try {
            auth = this.authenticationProvider.authenticate(auth);
        } catch (BadCredentialsException e) {
            throw new RuntimeException(e);
        }
        SecurityContext sc = new SecurityContextImpl();
        sc.setAuthentication(auth);

        SecurityContextHolder.setContext(sc);
    }
}