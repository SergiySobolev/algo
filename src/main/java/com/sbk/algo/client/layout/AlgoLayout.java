package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sbk.algo.client.activity.LoginActivity;
import com.sbk.algo.client.event.LoginSucceedEvent;
import com.sbk.algo.client.event.LogoutEvent;
import com.sbk.algo.client.event.handler.LoginSucceedEventHandler;
import com.sbk.algo.client.event.handler.LogoutEventHandler;
import com.sbk.algo.client.localization.AlgoConstants;

public class AlgoLayout extends Composite {
    private static AlgoLayoutUiBinder uiBinder = GWT.create(AlgoLayoutUiBinder.class);

    @UiField
    SimplePanel appContent;

    @UiField
    Header header;

    private AlgoConstants cst;

    private EventBus eventBus;

    private LoginActivity loginActivity;


    @Inject
    @UiConstructor
    public AlgoLayout(EventBus eventBus, AlgoConstants cst, LoginActivity loginActivity) {
        this.cst = cst;
        this.eventBus = eventBus;
        this.loginActivity = loginActivity;
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiFactory
    Header constructHeader() {
        final Header h = new Header();
        h.setSearchPlaceHolder(cst.searchAlgorithms());
        h.greetingPanel.addLogoutClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                loginActivity.logout();
            }
        });
        eventBus.addHandler(LoginSucceedEvent.TYPE, new LoginSucceedEventHandler() {
            @Override
            public void loginSucceed(LoginSucceedEvent event) {
                h.greetingPanel.showGreeting();
            }
        });
        eventBus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {
            @Override
            public void logout(LogoutEvent event) {
                h.greetingPanel.showLogin();
            }
        });
        return h;
    }

    public SimplePanel getAppContent() {
        return appContent;
    }

    interface AlgoLayoutUiBinder extends UiBinder<Widget, AlgoLayout> {
    }
}
