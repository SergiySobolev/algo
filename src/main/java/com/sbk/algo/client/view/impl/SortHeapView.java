package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.view.interfaces.ISortHeapView;

/**
 * Created by sobik on 09/11/2014.
 */
public class SortHeapView extends Composite implements ISortHeapView {

    private static SortHeapViewUiBinder uiBinder = GWT.create(SortHeapViewUiBinder.class);

    private ISortHeapPresenter presenter;

    public SortHeapView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(ISortHeapPresenter presenter) {
        this.presenter = presenter;
    }

    interface SortHeapViewUiBinder extends UiBinder<Widget, SortHeapView> {
    }
}
