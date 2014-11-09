package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.sbk.algo.client.view.interfaces.ISortingView;

/**
 * Created by sobik on 31/08/2014.
 */
@Singleton
public class SortingView extends Composite implements ISortingView {

    private static SortingViewUiBinder uiBinder = GWT.create(SortingViewUiBinder.class);

    ISortingPresenter sortingPresenter;

    public SortingView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(ISortingPresenter presenter) {
        this.sortingPresenter = presenter;
    }

    interface SortingViewUiBinder extends UiBinder<Widget, SortingView> {
    }
}
