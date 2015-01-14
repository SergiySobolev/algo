package com.sbk.core.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.sbk.core.client.gin.CoreInjector;

/**
 * Created by sobik on 14/01/2015.
 */
public class InitCore implements EntryPoint {
    @Override
    public void onModuleLoad() {
        initInjection();
    }

    private void initInjection() {
        GWT.create(CoreInjector.class);
    }
}
