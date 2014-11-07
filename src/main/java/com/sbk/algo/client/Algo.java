package com.sbk.algo.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.sbk.algo.client.gin.AlgoInjector;
import com.sbk.algo.client.layout.AlgoLayout;
import com.sbk.algo.client.resources.AlgoResources;

/**
 * Created by sobik on 02/11/2014.
 */
public class Algo implements EntryPoint {

    private SimplePanel appContent;

    public void onModuleLoad() {
        AlgoResources.INSTANCE.algoCSS().ensureInjected();
        AlgoInjector injector = AlgoInjector.INSTANCE;
        final AlgoLayout mainLayout = injector.getAlgoLayout();
        appContent = mainLayout.getAppContent();
        EventBus eventBus = injector.getEventBus();
        PlaceController placeController = injector.getPlaceController();
        // activate activity manager and init display
        ActivityMapper activityMapper = injector.getActivityMapper();
        ActivityManager activityManager = injector.getActivityManager();
        activityManager.setDisplay(appContent);
        PlaceHistoryHandler historyHandler = injector.getPlaceHistoryHandler();
        historyHandler.register(placeController, eventBus, null);

        RootLayoutPanel.get().add(mainLayout);
    }
}