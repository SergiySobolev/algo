package com.sbk.core.client.handlers;

import com.sbk.core.client.proxy.RequestInformation;
import com.sbk.core.client.widget.WaitGlassPanel;

/**
 * Created by sobik on 13/01/2015.
 */

public class WaitHandler implements GwtRequestHandler, GwtResponseHandler {

    final WaitGlassPanel glassPanel;

    public WaitHandler() {
        glassPanel = new WaitGlassPanel();
    }
    @Override
    public void processRequest(RequestInformation information) {
        if (showGlasses(information)) {
            glassPanel.center();
            glassPanel.show();
        }
    }

    @Override
    public void processResponse(RequestInformation information) {
        if (showGlasses(information)) {
            glassPanel.hide();
        }
    }

    private boolean showGlasses(RequestInformation ri) {
        return true;
    }
}
