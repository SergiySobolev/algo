package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.service.SortingServiceAsync;
import com.sbk.algo.client.view.interfaces.ISortingView;
import com.sbk.algo.client.view.presenters.ISortingPresenter;
import com.sbk.algo.shared.enums.SortingType;
import com.sbk.algo.shared.result.SortingResult;

import java.util.List;


/**
 * Created by sobik on 09/11/2014.
 */

public class SortingActivity extends AbstractAlgoActivity implements ISortingPresenter {

    @Inject
    private ISortingView view;

    @Inject
    private SortingServiceAsync sortingService;

    private SortingType sortingType;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

    @Override
    public void generateInputData() {
        sortingService.generate(100000, new AsyncCallback<List<Integer>>() {
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
        sortingService.sort(sortingType, new AsyncCallback<SortingResult>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(SortingResult result) {
                view.setSortedData(result.getResult());
                view.setElapsedTime(result.getChrono().getSeconds());
            }
        });
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }
}
