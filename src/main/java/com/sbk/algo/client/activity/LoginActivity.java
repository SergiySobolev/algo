package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.context.Context;
import com.sbk.algo.client.event.LoginSucceedEvent;
import com.sbk.algo.client.service.security.AuthServiceAsync;
import com.sbk.algo.client.view.interfaces.ILoginView;
import com.sbk.algo.client.view.presenters.ILoginPresenter;
import com.sbk.algo.shared.dto.AlgoUser;
import com.sbk.core.client.rpc.AlgoCallbackAdapter;

public class LoginActivity extends AbstractAlgoActivity implements ILoginPresenter {

    @Inject
    AuthServiceAsync authService;

    @Inject
    EventBus eventBus;

    @Inject
    ILoginView view;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        view.popup();
    }

    @Override
    public void login(String login, String pwd) {
        authService.authenticate(login, pwd, new AlgoCallbackAdapter<Void>() {
            @Override
            public void onSuccess(Void result) {
                authService.getAlgoUser(new AlgoCallbackAdapter<AlgoUser>() {
                    @Override
                    public void onSuccess(AlgoUser algoUser) {
                        Context.setAlgoUser(algoUser);
                        eventBus.fireEvent(new LoginSucceedEvent());
                    }
                });
            }
        });

    }
}
