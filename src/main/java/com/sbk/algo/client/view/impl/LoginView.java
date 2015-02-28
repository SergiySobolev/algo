package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.view.interfaces.ILoginView;
import com.sbk.algo.client.view.presenters.ILoginPresenter;

/**
 * Created by sobik on 28/02/2015.
 */
public class LoginView extends PopupPanel implements ILoginView {

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    private ILoginPresenter presenter;

    public LoginView() {
        super(false, true);
        add(uiBinder.createAndBindUi(this));
        setGlassEnabled(true);
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

    @UiTemplate(value = "LoginView.ui.xml")
    interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
    }
}
