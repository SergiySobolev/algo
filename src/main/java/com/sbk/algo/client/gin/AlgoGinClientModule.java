package com.sbk.algo.client.gin;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Singleton;
import com.sbk.algo.client.gin.providers.ActivityManagerProvider;
import com.sbk.algo.client.gin.providers.PlaceControllerProvider;
import com.sbk.algo.client.gin.providers.PlaceHistoryHandlerProvider;
import com.sbk.algo.client.history.AlgoActivityMapper;
import com.sbk.algo.client.history.AlgoHistoryMapper;
import com.sbk.algo.client.layout.AlgoLayout;

/**
 * Created by sobik on 06/11/2014.
 */
public class AlgoGinClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        //general
        bind(AlgoLayout.class).asEagerSingleton();
        bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();
        bind(ActivityMapper.class).to(AlgoActivityMapper.class).in(Singleton.class);
        bind(PlaceController.class).toProvider(PlaceControllerProvider.class).asEagerSingleton();
        bind(PlaceHistoryMapper.class).to(AlgoHistoryMapper.class).in(Singleton.class);
        bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).asEagerSingleton();
        bind(ActivityManager.class).toProvider(ActivityManagerProvider.class).asEagerSingleton();
    }

}
