package com.sbk.algo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.sbk.algo.client.layout.AlgoLayout;
import com.sbk.algo.client.resources.AlgoResources;

/**
 * Created by sobik on 02/11/2014.
 */
public class Algo implements EntryPoint {
    public void onModuleLoad() {
        AlgoResources.INSTANCE.algoCSS().ensureInjected();
        final AlgoLayout mainLayout = new AlgoLayout();
        RootLayoutPanel.get().add(mainLayout);
    }
}