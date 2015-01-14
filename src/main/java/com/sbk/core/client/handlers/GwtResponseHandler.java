package com.sbk.core.client.handlers;

import com.sbk.core.client.proxy.RequestInformation;

/**
 * Created by sobik on 23/12/2014.
 */
public interface GwtResponseHandler extends GeneralHandler {
    void processResponse(RequestInformation information);
}
