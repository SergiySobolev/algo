package com.sbk.algo.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.sbk.algo.client.event.handler.LoginSucceedEventHandler;

public class LoginSucceedEvent extends GwtEvent<LoginSucceedEventHandler> {

    public static Type<LoginSucceedEventHandler> TYPE = new Type<LoginSucceedEventHandler>();

    @Override
    public Type<LoginSucceedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoginSucceedEventHandler handler) {
        handler.loginSucceed(this);
    }
}
