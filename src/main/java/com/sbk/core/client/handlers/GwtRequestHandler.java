package com.sbk.core.client.handlers;

import com.sbk.core.client.proxy.RequestInformation;

public interface GwtRequestHandler extends GeneralHandler {
    void processRequest(RequestInformation information);
}
