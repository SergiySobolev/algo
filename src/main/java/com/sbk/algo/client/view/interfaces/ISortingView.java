package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by sobik on 31/08/2014.
 */
public interface ISortingView extends IsWidget {
    void setPresenter(ISortingPresenter presenter);

    void init();

    interface ISortingPresenter {

    }
}
