package com.sbk.algo.client.view.implementation;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;
import com.sbk.algo.client.resources.AlgoResources;
import com.sbk.algo.client.view.interfaces.IGraphView;

/**
 * Created by sobik on 08/11/2014.
 */

public class GraphView extends Composite implements IGraphView {

    FlowPanel content = new FlowPanel();

    IGraphPresenter presenter;

    @Inject
    AlgoResources resource;

    public GraphView() {
        buildUI();
    }

    @Override
    public void init() {
        content.addStyleName(resource.algoCSS().content());
    }

    private void buildUI() {
        content.add(new Button("graph"));
        initWidget(content);
    }

    @Override
    public void setPresenter(IGraphPresenter graphPresenter) {
        this.presenter = graphPresenter;
    }


}
