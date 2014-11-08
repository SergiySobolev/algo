package com.sbk.algo.client.view.implementation;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sbk.algo.client.resources.AlgoResources;
import com.sbk.algo.client.view.interfaces.ISortingView;

/**
 * Created by sobik on 31/08/2014.
 */
@Singleton
public class SortingView extends Composite implements ISortingView {

    FlowPanel content = new FlowPanel();

    ISortingPresenter sortingPresenter;

    @Inject
    private AlgoResources resources;

    public SortingView() {
        buildUI();
    }

    @Override
    public void init() {
        content.addStyleName(resources.algoCSS().content());
    }


    public void buildUI() {
        content.add(new Button("Sortttiiinnggg"));
        initWidget(content);
    }

    @Override
    public void setPresenter(ISortingPresenter presenter) {
        this.sortingPresenter = presenter;
    }
}
