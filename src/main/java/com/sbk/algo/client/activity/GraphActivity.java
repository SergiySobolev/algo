package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.view.interfaces.IGraphView;

/**
 * Created by sobik on 31/08/2014.
 */
public class GraphActivity extends AbstractAlgoActivity implements IGraphView.IGraphPresenter {

    @Inject
    private IGraphView view;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        view.init();
        panel.setWidget(view.asWidget());
    }

}
