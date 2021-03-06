package com.sbk.algo.client.service.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sbk.algo.shared.dto.AlgoUser;

public interface AuthServiceAsync {
    void authenticate(String login, String password, AsyncCallback<Void> async);

    void getAlgoUser(AsyncCallback<AlgoUser> async);

    void logout(AsyncCallback<Void> async);
}
