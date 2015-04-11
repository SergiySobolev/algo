package com.sbk.core.client.proxy;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class RequestInformation {
    private AsyncCallback callback;

    public AsyncCallback getCallback() {
        return callback;
    }

    public void setCallback(AsyncCallback callback) {
        this.callback = callback;
    }
}
