package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sbk.algo.client.view.implementation.SortingView;
import com.sbk.algo.client.view.interfaces.ISortingView;

/**
 * Created by sobik on 31/08/2014.
 */
public class SortingActivity extends AbstractAlgoActivity implements ISortingView.ISortingPresenter {


    private ISortingView view;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view = new SortingView();
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

}
