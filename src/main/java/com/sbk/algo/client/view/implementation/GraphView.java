package com.sbk.algo.client.view.implementation;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.sbk.algo.client.view.interfaces.IGraphView;

/**
 * Created by sobik on 08/11/2014.
 */
public class GraphView extends Composite implements IGraphView {

    IGraphPresenter presenter;

    public GraphView() {
        buildUI();
    }

    protected void buildUI() {
        FlowPanel content = new FlowPanel();
        content.add(new Button("graph"));
        initWidget(content);
    }

    @Override
    public void setPresenter(IGraphPresenter graphPresenter) {
        this.presenter = graphPresenter;
    }


}
