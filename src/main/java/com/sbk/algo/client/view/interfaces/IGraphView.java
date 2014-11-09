package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by sobik on 31/08/2014.
 */
public interface IGraphView extends IsWidget {
    void setPresenter(IGraphPresenter presenter);

    interface IGraphPresenter {
    }
}
