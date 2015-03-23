package com.sbk.algo.client.event.handler;

import com.google.gwt.event.shared.EventHandler;
import com.sbk.algo.client.event.LoginSucceedEvent;

public interface LoginSucceedEventHandler extends EventHandler {

    void loginSucceed(LoginSucceedEvent event);
}
