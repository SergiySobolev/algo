package com.sbk.core.client.handlers;

import com.google.gwt.user.client.Window;
import com.sbk.core.client.proxy.RequestInformation;

/**
 * Created by sobik on 13/01/2015.
 */
public class WaitHandler implements GwtRequestHandler, GwtResponseHandler {
    @Override
    public void processRequest(RequestInformation information) {
        Window.alert("Request handling");
    }

    @Override
    public void processResponse(RequestInformation information) {
        Window.alert("Response handling");
    }
}
