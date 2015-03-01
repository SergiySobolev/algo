package com.sbk.algo.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.sbk.core.client.gin.CoreGinModule;

@GinModules(value = {AlgoGinClientModule.class, CoreGinModule.class})
public interface AlgoInjector extends Ginjector {
}

