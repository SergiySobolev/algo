package com.sbk.algo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.sbk.algo.client.gin.AlgoInjector;
import com.sbk.algo.client.layout.AlgoLayout;
import com.sbk.algo.client.resources.AlgoResources;

/**
 * Created by sobik on 02/11/2014.
 */
public class Algo implements EntryPoint {
    public void onModuleLoad() {
        AlgoResources.INSTANCE.algoCSS().ensureInjected();
        AlgoInjector injector = AlgoInjector.INSTANCE;
        final AlgoLayout mainLayout = injector.getAlgoLayout();
        RootLayoutPanel.get().add(mainLayout);
    }
}