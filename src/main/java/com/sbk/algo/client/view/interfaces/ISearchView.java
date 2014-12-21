package com.sbk.algo.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.sbk.algo.client.view.presenters.ISearchPresenter;

import java.util.List;

/**
 * Created by sobik on 21/12/2014.
 */
public interface ISearchView extends IsWidget {

    void setPresenter(ISearchPresenter presenter);

    void setGeneratedData(List<Integer> generList);

    void setMaxData(Integer result);
}
