package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by sobik on 09/11/2014.
 */
public interface ISortHeapView extends IsWidget {
    void setPresenter(ISortHeapPresenter presenter);

    interface ISortHeapPresenter {
    }
}
