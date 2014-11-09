package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.view.interfaces.ISortHeapView;


/**
 * Created by sobik on 09/11/2014.
 */

public class SortHeapActivity extends AbstractAlgoActivity implements ISortHeapView.ISortHeapPresenter {

    @Inject
    private ISortHeapView view;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

}
