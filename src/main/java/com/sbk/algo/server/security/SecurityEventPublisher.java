package com.sbk.algo.server.security;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher
            (ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish() {
        AuthenticationSuccessEvent ce = new AuthenticationSuccessEvent(SecurityContextHolder.getContext().getAuthentication());
        publisher.publishEvent(ce);
    }
}
