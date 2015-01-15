package com.sbk.core.client.handlers;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.inject.Singleton;
import com.sbk.core.client.proxy.RequestInformation;

import java.util.List;

/**
 * Created by sobik on 13/01/2015.
 */
@Singleton
public class GeneralHandlerManager {

    private static GeneralHandlerManager INSTANCE;

    List<GwtRequestHandler> requestHandlerList = Lists.newArrayList();

    List<GwtResponseHandler> responseHandlerList = Lists.newArrayList();

    public static GeneralHandlerManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = GWT.create(GeneralHandlerManager.class);
        }
        return INSTANCE;
    }

    public void addRequestHandler(GeneralHandler handler) {
        if (handler instanceof GwtRequestHandler) {
            requestHandlerList.add((GwtRequestHandler) handler);
        }
    }

    public void addResponseHandler(GeneralHandler handler) {
        if (handler instanceof GwtResponseHandler) {
            responseHandlerList.add((GwtResponseHandler) handler);
        }
    }

    public void processRequestToListeners(RequestInformation ri) {
        if (ri != null) {
            for (GwtRequestHandler grh : requestHandlerList) {
                grh.processRequest(ri);
            }
        }
    }

    public void processResponseToListeners(RequestInformation ri) {
        if (ri != null) {
            for (GwtResponseHandler grh : responseHandlerList) {
                grh.processResponse(ri);
            }
        }
    }

}
