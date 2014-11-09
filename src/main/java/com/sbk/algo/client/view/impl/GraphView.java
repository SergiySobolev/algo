package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.view.interfaces.IGraphView;

/**
 * Created by sobik on 08/11/2014.
 */

public class GraphView extends Composite implements IGraphView {

    private static GraphViewUiBinder uiBinder = GWT.create(GraphViewUiBinder.class);

    IGraphPresenter presenter;

    public GraphView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(IGraphPresenter graphPresenter) {
        this.presenter = graphPresenter;
    }

    interface GraphViewUiBinder extends UiBinder<Widget, GraphView> {
    }

}
