package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


/**
 * Created by sobik on 03/11/2014.
 */
public class AlgoLayout extends Composite {
    private static AlgoLayoutUiBinder uiBinder = GWT.create(AlgoLayoutUiBinder.class);

    public AlgoLayout() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface AlgoLayoutUiBinder extends UiBinder<Widget, AlgoLayout> {
    }

}
