package com.sbk.core.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.core.client.gin.CoreInjector;
import com.sbk.core.client.resources.CoreResources;

/**
 * Created by sobik on 18/01/2015.
 */

public class WaitGlassPanel extends PopupPanel {

    private static GlassPanelUiBinder uiBinder = GWT.create(GlassPanelUiBinder.class);
    CoreResources resources = CoreInjector.INSTANCE.getCoreResources();

    public WaitGlassPanel() {
        super(false, true);
        this.setGlassStyleName(resources.coreCSS().glass());
        add(uiBinder.createAndBindUi(this));
        setGlassEnabled(true);
    }

    @UiTemplate("GlassPanel.ui.xml")
    interface GlassPanelUiBinder extends UiBinder<Widget, WaitGlassPanel> {
    }
}
