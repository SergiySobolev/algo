package com.sbk.algo.client.event;


import com.google.gwt.event.shared.GwtEvent;
import com.sbk.algo.client.event.handler.LogoutEventHandler;

public class LogoutEvent extends GwtEvent<LogoutEventHandler> {

    public static Type<LogoutEventHandler> TYPE = new Type<LogoutEventHandler>();

    @Override
    public Type<LogoutEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LogoutEventHandler logoutEventHandler) {
        logoutEventHandler.logout(this);
    }
}
