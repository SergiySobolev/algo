package com.sbk.core.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.sbk.core.client.gin.CoreInjector;
import com.sbk.core.client.resources.CoreResources;

public class InitCore implements EntryPoint {

    @Inject
    static CoreResources resources;

    @Override
    public void onModuleLoad() {
        initInjection();
        resources.coreCSS().ensureInjected();
    }

    private void initInjection() {
        GWT.create(CoreInjector.class);
    }
}
