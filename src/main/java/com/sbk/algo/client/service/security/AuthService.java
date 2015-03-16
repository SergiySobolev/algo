package com.sbk.algo.client.service.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("algoserv/authService")
public interface AuthService extends RemoteService {
    String retrieveUsername();

    void authenticate(String login, String password);
}
