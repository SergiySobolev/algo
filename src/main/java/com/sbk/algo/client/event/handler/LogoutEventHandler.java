package com.sbk.algo.client.event.handler;

import com.google.gwt.event.shared.EventHandler;
import com.sbk.algo.client.event.LogoutEvent;

public interface LogoutEventHandler extends EventHandler {

    void logout(LogoutEvent event);
}
