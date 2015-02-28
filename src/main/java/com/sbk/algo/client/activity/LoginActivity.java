package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.view.interfaces.ILoginView;
import com.sbk.algo.client.view.presenters.ILoginPresenter;

/**
 * Created by sobik on 28/02/2015.
 */
public class LoginActivity extends AbstractAlgoActivity implements ILoginPresenter {

    @Inject
    ILoginView view;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        view.popup();
    }

    @Override
    public void login() {

    }
}
