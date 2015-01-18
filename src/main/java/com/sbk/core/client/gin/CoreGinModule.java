package com.sbk.core.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.sbk.core.client.InitCore;
import com.sbk.core.client.handlers.GeneralHandlerManager;
import com.sbk.core.client.localization.CoreConstants;
import com.sbk.core.client.proxy.AsyncCallbackWrapper;
import com.sbk.core.client.resources.CoreResources;

/**
 * Created by sobik on 14/01/2015.
 */
public class CoreGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(CoreResources.class).asEagerSingleton();
        bind(CoreConstants.class).asEagerSingleton();
        requestStaticInjection(InitCore.class);
    }

    @Provides
    AsyncCallbackWrapper getNewAsyncCallbackWrapper(GeneralHandlerManager generalHandlerManager) {
        return new AsyncCallbackWrapper(generalHandlerManager);
    }
}
