package com.sbk.core.client.handlers;

import com.sbk.core.client.proxy.RequestInformation;

public interface GwtErrorHandler extends GeneralHandler {
    void processError(RequestInformation information);
}
