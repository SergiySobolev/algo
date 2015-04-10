package com.sbk.algo.server.security;

import com.sbk.algo.server.entity.PrincipalEntity;
import com.sbk.algo.server.repo.PrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static Map<String, String> users = new HashMap<String, String>();

    static {
        users.put("fabrizio", "javacodegeeks");
        users.put("justin", "javacodegeeks");
    }

    @Autowired
    private PrincipalRepository principalRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String login = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        PrincipalEntity principal = principalRepository.findPrincipalByLogin(login);
        if (principal == null)
            throw new UsernameNotFoundException("User not found");

        if (!principal.getPassword().equals(password))
            throw new BadCredentialsException("Invalid password");

        Authentication customAuthentication =
                new CustomUserAuthentication("ROLE_USER", authentication);
        customAuthentication.setAuthenticated(true);

        return customAuthentication;

    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}