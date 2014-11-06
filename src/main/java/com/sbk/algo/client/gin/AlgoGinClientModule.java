package com.sbk.algo.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.sbk.algo.client.layout.AlgoLayout;

/**
 * Created by sobik on 06/11/2014.
 */
public class AlgoGinClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(AlgoLayout.class).asEagerSingleton();
    }
}
