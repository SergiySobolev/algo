package com.sbk.algo.server.security;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sbk.algo.client.service.security.AuthService;
import com.sbk.algo.shared.dto.AlgoUser;
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

    private SecurityContext sc = new SecurityContextImpl();

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
        sc.setAuthentication(auth);
        SecurityContextHolder.setContext(sc);
    }

    @Override
    public AlgoUser getAlgoUser() {
        AlgoUser user = new AlgoUser();
        Object principal = sc.getAuthentication().getPrincipal();
        user.setName((String) principal);
        return user;
    }
}