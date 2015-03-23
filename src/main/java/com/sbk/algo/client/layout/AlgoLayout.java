package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sbk.algo.client.context.Context;
import com.sbk.algo.client.event.LoginSucceedEvent;
import com.sbk.algo.client.event.handler.LoginSucceedEventHandler;
import com.sbk.algo.client.localization.AlgoConstants;

public class AlgoLayout extends Composite {
    private static AlgoLayoutUiBinder uiBinder = GWT.create(AlgoLayoutUiBinder.class);

    @UiField
    SimplePanel appContent;

    @UiField
    Header header;

    private AlgoConstants cst;

    private EventBus eventBus;


    @Inject
    @UiConstructor
    public AlgoLayout(EventBus eventBus, AlgoConstants cst) {
        this.cst = cst;
        this.eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiFactory
    Header constructHeader() {
        Header h = new Header();
        h.setSearchPlaceHolder(cst.searchAlgorithms());
        eventBus.addHandler(LoginSucceedEvent.TYPE, new LoginSucceedEventHandler() {
            @Override
            public void loginSucceed(LoginSucceedEvent event) {
                Window.alert(Context.getAlgoUser().getName());
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
