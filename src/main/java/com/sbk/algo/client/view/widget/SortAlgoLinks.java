package com.sbk.algo.client.view.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by sobik on 09/11/2014.
 */
public class SortAlgoLinks extends Composite {

    private static SortAlgoLinksUiBinder uiBinder = GWT.create(SortAlgoLinksUiBinder.class);

    public SortAlgoLinks() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface SortAlgoLinksUiBinder extends UiBinder<Widget, SortAlgoLinks> {
    }
}
