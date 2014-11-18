package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.view.interfaces.ISortingFacadeView;

/**
 * Created by sobik on 31/08/2014.
 */
public class SortingFacadeActivity extends AbstractAlgoActivity implements ISortingFacadeView.ISortingFacadePresenter {

    @Inject
    private ISortingFacadeView view;


    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

}
