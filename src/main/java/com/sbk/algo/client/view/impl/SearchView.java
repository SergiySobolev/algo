package com.sbk.algo.client.view.impl;

import com.google.common.base.Joiner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.view.interfaces.ISearchView;
import com.sbk.algo.client.view.presenters.ISearchPresenter;

import java.util.List;

/**
 * Created by sobik on 21/12/2014.
 */
public class SearchView extends Composite implements ISearchView {

    private static SearchViewUiBinder uiBinder = GWT.create(SearchViewUiBinder.class);
    @UiField
    Button generBtn;
    @UiField
    Label generListLbl;
    @UiField
    Button findMaxBtn;
    @UiField
    Label findMaxResultLbl;

    ISearchPresenter presenter;

    public SearchView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("generBtn")
    void handleClickGenerateButton(ClickEvent e) {
        presenter.generateInputData();
    }

    @UiHandler("findMaxBtn")
    void handleClickFindMaxButton(ClickEvent e) {
        presenter.findMax();
    }

    @Override
    public void setPresenter(ISearchPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setGeneratedData(List<Integer> generList) {
        generListLbl.setText(Joiner.on(",").skipNulls().join(generList));
    }

    @Override
    public void setMaxData(Integer result) {
        findMaxResultLbl.setText(result.toString());
    }

    interface SearchViewUiBinder extends UiBinder<Widget, SearchView> {
    }

}
