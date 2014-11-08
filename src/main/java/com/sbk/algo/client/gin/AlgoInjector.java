package com.sbk.algo.client.gin;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.sbk.algo.client.layout.AlgoLayout;


/**
 * Created by sobik on 06/11/2014.
 */
@GinModules(AlgoGinClientModule.class)
public interface AlgoInjector extends Ginjector {

    static final AlgoInjector INSTANCE = GWT.create(AlgoInjector.class);

    AlgoLayout getAlgoLayout();

    EventBus getEventBus();

    PlaceController getPlaceController();

    ActivityMapper getActivityMapper();

    PlaceHistoryHandler getPlaceHistoryHandler();

    ActivityManager getActivityManager();

    Place getDefaultPlace();
}
