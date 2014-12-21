package com.sbk.algo.client.view.impl;

import com.google.common.base.Joiner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.sbk.algo.client.view.interfaces.ISearchView;
import com.sbk.algo.client.view.presenters.ISearchPresenter;

import java.util.List;

/**
 * Created by sobik on 21/12/2014.
 */
public class SearchView extends Composite implements ISearchView {

    private static SearchViewUiBinder uiBinder = GWT.create(SearchViewUiBinder.class);
    @UiField
    Button generButton;
    @UiField
    FlowPanel inputDataPanel;
    @UiField
    Label generListLbl;
    ISearchPresenter presenter;

    public SearchView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("generButton")
    void handleClick(ClickEvent e) {
        presenter.generateInputData();
    }

    @Override
    public void setPresenter(ISearchPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setGeneratedData(List<Integer> generList) {
        generListLbl.setText(Joiner.on(",").skipNulls().join(generList));
    }

    interface SearchViewUiBinder extends UiBinder<Widget, SearchView> {
    }

}
