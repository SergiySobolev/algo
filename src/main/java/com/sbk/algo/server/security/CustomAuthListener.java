package com.sbk.algo.server.security;

import com.sbk.algo.server.entity.LoginLogoutAuditEntity;
import com.sbk.algo.server.repo.LoginLogoutAuditRepository;
import com.sbk.algo.server.repo.PrincipalRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthListener implements ApplicationListener<AbstractAuthenticationEvent> {

    private static final Log logger = LogFactory.getLog(CustomAuthListener.class);

    @Autowired
    private LoginLogoutAuditRepository loginLogoutAuditRepo;

    @Autowired
    private PrincipalRepository principalRepo;

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {

        if (event instanceof AuthenticationSuccessEvent) {
            LoginLogoutAuditEntity llAudit = new LoginLogoutAuditEntity();
            String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            llAudit.setPrincipal(principalRepo.findPrincipalByLogin(login));
            loginLogoutAuditRepo.save(llAudit);
            logger.info(String.format("User %s logged in on %s", login, llAudit.getInTime()));
        }

        if (event instanceof AbstractAuthenticationFailureEvent) {

        }
    }

}