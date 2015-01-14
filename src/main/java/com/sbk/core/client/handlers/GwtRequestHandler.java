package com.sbk.core.client.handlers;

import com.sbk.core.client.proxy.RequestInformation;

/**
 * Created by sobik on 23/12/2014.
 */
public interface GwtRequestHandler extends GeneralHandler {
    void processRequest(RequestInformation information);
}
