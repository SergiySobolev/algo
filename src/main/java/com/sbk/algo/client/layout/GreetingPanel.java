package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.sbk.algo.client.context.Context;

public class GreetingPanel extends Composite {

    private static GreetingPanelUIBinder uiBinder = GWT.create(GreetingPanelUIBinder.class);

    @UiField
    FlowPanel loggedPanel;

    @UiField
    FlowPanel unLoggedPanel;

    @UiField
    InlineLabel greetingLabel;

    @UiField
    Anchor logoutLink;

    @UiConstructor
    public GreetingPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        init();
    }

    private void init() {
        showLogin();
    }

    public void showGreeting() {
        greetingLabel.setText(Context.getAlgoUser().getName());
        loggedPanel.setVisible(true);
        unLoggedPanel.setVisible(false);
    }

    public void showLogin() {
        greetingLabel.setText(null);
        loggedPanel.setVisible(false);
        unLoggedPanel.setVisible(true);
    }

    public void addLogoutClickHandler(ClickHandler logoutClickHandler) {
        logoutLink.addClickHandler(logoutClickHandler);
    }

    @UiTemplate("GreetingPanel.ui.xml")
    interface GreetingPanelUIBinder extends UiBinder<Widget, GreetingPanel> {
    }

}
