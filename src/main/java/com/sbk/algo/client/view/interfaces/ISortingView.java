package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.sbk.algo.client.view.presenters.ISortingPresenter;

import java.util.List;

/**
 * Created by sobik on 09/11/2014.
 */
public interface ISortingView extends IsWidget {

    void setPresenter(ISortingPresenter presenter);

    void setGeneratedData(List<Integer> generList);

    void setSortedData(List<Integer> sortedData);

}
