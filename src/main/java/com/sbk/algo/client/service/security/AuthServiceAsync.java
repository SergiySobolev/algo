package com.sbk.algo.client.service.security;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthServiceAsync {
    void retrieveUsername(AsyncCallback<String> async);

    void authenticate(String login, String password, AsyncCallback<Void> async);
}
