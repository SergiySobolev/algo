package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sbk.algo.client.localization.AlgoConstants;
import com.sbk.algo.client.view.interfaces.ILoginView;
import com.sbk.algo.client.view.presenters.ILoginPresenter;
import com.sbk.algo.client.view.widget.LoginPanel;
import com.sbk.core.client.resources.CoreResources;
import com.sbk.core.client.widget.CloseablePopupPanel;

public class LoginView extends CloseablePopupPanel implements ILoginView {

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);
    @UiField
    LoginPanel loginPanel;

    private ILoginPresenter presenter;

    @Inject
    public LoginView(AlgoConstants algoConstants, CoreResources resources) {
        super(true, true);
        setText(algoConstants.login());
        setGlassStyleName(resources.coreCSS().glass());
        add(uiBinder.createAndBindUi(this));
    }

    @UiFactory
    LoginPanel constructLoginPanel() {
        LoginPanel lp = new LoginPanel();
        lp.addOkClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.login(loginPanel.getLogin(), loginPanel.getPassword());
                LoginView.this.hide();
            }
        });
        lp.addCancelClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                LoginView.this.hide();
            }
        });
        return lp;
    }

    @Override
    public void setPresenter(ILoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void popup() {
        this.center();
        this.show();
    }

    @Override
    public void hide() {
        super.hide();
        History.newItem("");
    }

    @UiTemplate(value = "LoginView.ui.xml")
    interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
    }
}
