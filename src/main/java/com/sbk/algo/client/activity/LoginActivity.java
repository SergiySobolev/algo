package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.context.Context;
import com.sbk.algo.client.event.LoginSucceedEvent;
import com.sbk.algo.client.event.LogoutEvent;
import com.sbk.algo.client.localization.AlgoMessages;
import com.sbk.algo.client.service.security.AuthServiceAsync;
import com.sbk.algo.client.view.interfaces.ILoginView;
import com.sbk.algo.client.view.presenters.ILoginPresenter;
import com.sbk.algo.shared.dto.AlgoUser;
import com.sbk.core.client.rpc.AlgoCallbackAdapter;
import com.sbk.core.client.widget.PanelBuilder;

public class LoginActivity extends AbstractAlgoActivity implements ILoginPresenter {

    @Inject
    AuthServiceAsync authService;

    @Inject
    EventBus eventBus;

    @Inject
    ILoginView view;

    @Inject
    AlgoMessages msg;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        view.popup();
    }

    @Override
    public void login(String login, String pwd) {
        authService.authenticate(login, pwd, new AlgoCallbackAdapter<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                PanelBuilder.errorPanel().withMessage(msg.loginFailure()).build();
            }

            @Override
            public void onSuccess(Void result) {
                authService.getAlgoUser(new AlgoCallbackAdapter<AlgoUser>() {
                    @Override
                    public void onSuccess(AlgoUser algoUser) {
                        Context.setAlgoUser(algoUser);
                        PanelBuilder.messagePanel().withMessage(msg.loginSucceed(Context.getAlgoUser().getName())).build();
                        eventBus.fireEvent(new LoginSucceedEvent());
                    }
                });
            }
        });
    }

    @Override
    public void logout() {
        authService.logout(new AlgoCallbackAdapter<Void>() {
            @Override
            public void onSuccess(Void result) {
                PanelBuilder.messagePanel().withMessage(msg.logout(Context.getAlgoUser().getName())).build();
                Context.setAlgoUser(null);
                eventBus.fireEvent(new LogoutEvent());
            }
        });
    }
}
