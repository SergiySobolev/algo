package com.sbk.algo.client.gin;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.sbk.algo.client.Algo;
import com.sbk.algo.client.gin.providers.ActivityManagerProvider;
import com.sbk.algo.client.gin.providers.PlaceControllerProvider;
import com.sbk.algo.client.gin.providers.PlaceHistoryHandlerProvider;
import com.sbk.algo.client.history.AlgoActivityMapper;
import com.sbk.algo.client.history.AlgoHistoryMapper;
import com.sbk.algo.client.history.AlgoMapperVisitor;
import com.sbk.algo.client.history.AlgoMapperVisitorImpl;
import com.sbk.algo.client.layout.AlgoLayout;
import com.sbk.algo.client.localization.AlgoConstants;
import com.sbk.algo.client.place.SortingPlace;
import com.sbk.algo.client.resources.AlgoResources;
import com.sbk.algo.client.view.impl.*;
import com.sbk.algo.client.view.interfaces.*;
import com.sbk.core.client.handlers.GeneralHandler;
import com.sbk.core.client.handlers.WaitHandler;

public class AlgoGinClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        //general
        bind(AlgoLayout.class).asEagerSingleton();
        bind(ActivityMapper.class).to(AlgoActivityMapper.class).in(Singleton.class);
        bind(PlaceController.class).toProvider(PlaceControllerProvider.class).asEagerSingleton();
        bind(PlaceHistoryMapper.class).to(AlgoHistoryMapper.class).in(Singleton.class);
        bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).asEagerSingleton();
        bind(ActivityManager.class).toProvider(ActivityManagerProvider.class).asEagerSingleton();
        bind(Place.class).to(SortingPlace.class);
        bind(AlgoResources.class).in(Singleton.class);
        bind(AlgoConstants.class).in(Singleton.class);
        //views
        bind(ISortingFacadeView.class).to(SortingFacadeView.class).in(Singleton.class);
        bind(IGraphView.class).to(GraphView.class).in(Singleton.class);
        bind(ISortingView.class).to(SortingView.class).in(Singleton.class);
        bind(ISearchView.class).to(SearchView.class).in(Singleton.class);
        bind(ILoginView.class).to(LoginView.class).in(Singleton.class);

        bind(AlgoMapperVisitor.class).to(AlgoMapperVisitorImpl.class).in(Singleton.class);
        bind(GeneralHandler.class).annotatedWith(Names.named("waitHandler")).to(WaitHandler.class).in(Singleton.class);

        bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();

        requestStaticInjection(Algo.class);
    }

}
