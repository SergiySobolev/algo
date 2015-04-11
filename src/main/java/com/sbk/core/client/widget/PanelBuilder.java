package com.sbk.core.client.widget;


import com.sbk.core.client.resources.CoreResources;

import static com.sbk.core.client.gin.CoreInjector.INSTANCE;

public abstract class PanelBuilder {
    protected CoreResources coreResources = INSTANCE.getCoreResources();

    public static PanelBuilder messagePanel() {
        return new FadingPanelBuilder(false);
    }

    public static PanelBuilder errorPanel() {
        return new FadingPanelBuilder(true);
    }

    public abstract void build();

    public abstract PanelBuilder withMessage(String message);
}

class FadingPanelBuilder extends PanelBuilder {

    private String message;
    private boolean isError;

    public FadingPanelBuilder(boolean isError) {
        this.isError = isError;
    }

    public PanelBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public void build() {
        FadingPanel panel = new FadingPanel(message);
        String style = isError ? coreResources.coreCSS().red() : coreResources.coreCSS().green();
        panel.setStyleName(style);
        panel.show();
    }
}