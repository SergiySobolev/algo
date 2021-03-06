package com.sbk.core.client.gin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.sbk.core.client.handlers.GeneralHandlerManager;
import com.sbk.core.client.proxy.AsyncCallbackWrapper;
import com.sbk.core.client.resources.CoreResources;

/**
 * Created by sobik on 14/01/2015.
 */
@GinModules(CoreGinModule.class)
public interface CoreInjector extends Ginjector {
    public static final CoreInjector INSTANCE = GWT.create(CoreInjector.class);

    public GeneralHandlerManager getHandlerManager();

    public AsyncCallbackWrapper getNewAsyncCalbackWrapper();

    public CoreResources getCoreResources();
}
