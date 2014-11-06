package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by sobik on 06/11/2014.
 */
public class Header extends Composite {
    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    public Header() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface HeaderUiBinder extends UiBinder<Widget, Header> {
    }
}
