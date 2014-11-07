package com.sbk.algo.client.view.implementation;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.sbk.algo.client.view.interfaces.ISortingView;

/**
 * Created by sobik on 31/08/2014.
 */
public class SortingView extends Composite implements ISortingView {

    ISortingPresenter sortingPresenter;

    public SortingView() {
        buildUI();
    }

    protected void buildUI() {
        FlowPanel content = new FlowPanel();
        content.add(new Button("Sortttiiinnggg"));
        initWidget(content);
    }

    @Override
    public void setPresenter(ISortingPresenter presenter) {
        this.sortingPresenter = presenter;
    }
}
