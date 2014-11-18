package com.sbk.algo.client.view.impl;

import com.google.common.base.Joiner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.sbk.algo.client.view.interfaces.ISortingView;
import com.sbk.algo.client.view.presenters.ISortingPresenter;

import java.util.List;

/**
 * Created by sobik on 09/11/2014.
 */
public class SortingView extends Composite implements ISortingView {

    private static SortHeapViewUiBinder uiBinder = GWT.create(SortHeapViewUiBinder.class);
    @UiField
    Button generButton;
    @UiField
    Button sortButton;
    @UiField
    FlowPanel inputDataPanel;
    @UiField
    FlowPanel outputDataPanel;
    @UiField
    Label generListLbl;
    @UiField
    Label sortedListLbl;
    private ISortingPresenter presenter;

    public SortingView() {
        initWidget(uiBinder.createAndBindUi(this));
        manageEvents();
    }

    private void manageEvents() {
        generButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.generateInputData();
            }
        });
        sortButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.sort();
            }
        });
    }

    @Override
    public void setPresenter(ISortingPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setGeneratedData(List<Integer> generData) {
        generListLbl.setText(Joiner.on(",").skipNulls().join(generData));
    }

    @Override
    public void setSortedData(List<Integer> sortedData) {
        sortedListLbl.setText(Joiner.on(",").skipNulls().join(sortedData));
    }


    @UiTemplate("SortingView.ui.xml")
    interface SortHeapViewUiBinder extends UiBinder<Widget, SortingView> {
    }
}
