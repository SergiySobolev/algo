package com.sbk.algo.client.service.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sbk.algo.shared.util.AlgoUser;

@RemoteServiceRelativePath("algoserv/authService")
public interface AuthService extends RemoteService {
    void authenticate(String login, String password);

    AlgoUser getAlgoUser();
}