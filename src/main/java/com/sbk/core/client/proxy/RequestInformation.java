package com.sbk.core.client.proxy;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by sobik on 13/01/2015.
 */
public class RequestInformation {
    private AsyncCallback callback;

    public AsyncCallback getCallback() {
        return callback;
    }

    public void setCallback(AsyncCallback callback) {
        this.callback = callback;
    }
}
