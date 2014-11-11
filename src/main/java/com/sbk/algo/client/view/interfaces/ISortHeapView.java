package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

/**
 * Created by sobik on 09/11/2014.
 */
public interface ISortHeapView extends IsWidget {

    void setPresenter(ISortHeapPresenter presenter);

    void setGeneratedData(List<Integer> generList);

    void setSortedData(List<Integer> sortedData);

    interface ISortHeapPresenter {
        void generateInputData();

        void sort();
    }
}
