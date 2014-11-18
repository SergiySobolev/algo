package com.sbk.algo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;
import com.sbk.algo.client.view.interfaces.ISortingFacadeView;

/**
 * Created by sobik on 31/08/2014.
 */
@Singleton
public class SortingFacadeView extends Composite implements ISortingFacadeView {

    private static SortingViewUiBinder uiBinder = GWT.create(SortingViewUiBinder.class);

    ISortingFacadePresenter sortingPresenter;

    public SortingFacadeView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(ISortingFacadePresenter presenter) {
        this.sortingPresenter = presenter;
    }

    interface SortingViewUiBinder extends UiBinder<Widget, SortingFacadeView> {
    }
}
