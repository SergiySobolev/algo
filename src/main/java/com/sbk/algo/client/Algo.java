package com.sbk.algo.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.sbk.algo.client.gin.AlgoInjector;
import com.sbk.algo.client.layout.AlgoLayout;
import com.sbk.algo.client.resources.AlgoResources;

/**
 * Created by sobik on 02/11/2014.
 */
public class Algo implements EntryPoint {

    @Inject
    static AlgoLayout mainLayout;
    @Inject
    static EventBus eventBus;
    @Inject
    static PlaceController placeController;
    @Inject
    static ActivityManager activityManager;
    @Inject
    static PlaceHistoryHandler historyHandler;
    @Inject
    static Place defaultPlace;
    @Inject
    static AlgoResources resources;

    private SimplePanel appContent;

    public void onModuleLoad() {
        initInjection();
        resources.algoCSS().ensureInjected();
        appContent = mainLayout.getAppContent();
        activityManager.setDisplay(appContent);
        historyHandler.register(placeController, eventBus, defaultPlace);
        RootLayoutPanel.get().add(mainLayout);
        History.newItem("sorting:");
    }

    private void initInjection() {
        GWT.create(AlgoInjector.class);
    }
}