package com.sbk.algo.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.sbk.algo.client.service.SearchServiceAsync;
import com.sbk.algo.client.view.interfaces.ISearchView;
import com.sbk.algo.client.view.presenters.ISearchPresenter;
import com.sbk.core.client.rpc.AlgoCallbackAdapter;

import java.util.List;


/**
 * Created by sobik on 09/11/2014.
 */

public class SearchActivity extends AbstractAlgoActivity implements ISearchPresenter {

    @Inject
    private ISearchView view;

    @Inject
    private SearchServiceAsync searchService;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

    @Override
    public void generateInputData() {
        searchService.generate(20, new AlgoCallbackAdapter<List<Integer>>() {
            @Override
            public void onSuccess(List<Integer> result) {
                view.setGeneratedData(result);
            }
        });
    }

}
