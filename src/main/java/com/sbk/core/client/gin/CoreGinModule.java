package com.sbk.core.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.sbk.core.client.InitCore;

/**
 * Created by sobik on 14/01/2015.
 */
public class CoreGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        requestStaticInjection(InitCore.class);
    }
}
