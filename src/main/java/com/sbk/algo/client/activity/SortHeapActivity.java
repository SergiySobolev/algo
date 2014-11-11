package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.service.SortingServiceAsync;
import com.sbk.algo.client.view.interfaces.ISortHeapView;

import java.util.List;


/**
 * Created by sobik on 09/11/2014.
 */

public class SortHeapActivity extends AbstractAlgoActivity implements ISortHeapView.ISortHeapPresenter {

    @Inject
    private ISortHeapView view;

    @Inject
    private SortingServiceAsync sortingService;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

    @Override
    public void generateInputData() {
        sortingService.generate(50, new AsyncCallback<List<Integer>>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(List<Integer> result) {
                view.setGeneratedData(result);
            }
        });
    }

    @Override
    public void sort() {
        sortingService.sort(new AsyncCallback<List<Integer>>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(List<Integer> result) {
                view.setSortedData(result);
            }
        });
    }
}
