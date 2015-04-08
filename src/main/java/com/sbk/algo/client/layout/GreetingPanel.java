package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.context.Context;

public class GreetingPanel extends Composite {

    private static GreetingPanelUIBinder uiBinder = GWT.create(GreetingPanelUIBinder.class);

    @UiField
    FlowPanel loggedPanel;

    @UiField
    FlowPanel unLoggedPanel;

    @UiField
    InlineLabel greetingLabel;

    @UiConstructor
    public GreetingPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        init();
    }

    private void init() {
        loggedPanel.setVisible(false);
    }

    public void showGreeting() {
        greetingLabel.setText(Context.getAlgoUser().getName());
        loggedPanel.setVisible(true);
        unLoggedPanel.setVisible(false);
    }

    @UiTemplate("GreetingPanel.ui.xml")
    interface GreetingPanelUIBinder extends UiBinder<Widget, GreetingPanel> {
    }

}
