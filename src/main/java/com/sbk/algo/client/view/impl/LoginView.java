package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.view.interfaces.ILoginView;
import com.sbk.algo.client.view.presenters.ILoginPresenter;
import com.sbk.core.client.gin.CoreInjector;
import com.sbk.core.client.resources.CoreResources;

public class LoginView extends PopupPanel implements ILoginView {

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    private ILoginPresenter presenter;

    private CoreResources resources = CoreInjector.INSTANCE.getCoreResources();

    public LoginView() {
        super(false, true);
        this.setGlassStyleName(resources.coreCSS().glass());
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
