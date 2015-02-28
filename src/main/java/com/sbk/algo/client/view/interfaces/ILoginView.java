package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.sbk.algo.client.view.presenters.ILoginPresenter;
import com.sbk.core.client.dom.CanPopup;

/**
 * Created by sobik on 31/08/2014.
 */
public interface ILoginView extends IsWidget, CanPopup {
    void setPresenter(ILoginPresenter presenter);
}
