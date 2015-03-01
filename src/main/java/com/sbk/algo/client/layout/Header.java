package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.algo.client.localization.AlgoConstants;

public class Header extends Composite {
    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    @UiField
    TextBox searchBox;

    private AlgoConstants cst = GWT.create(AlgoConstants.class);

    public Header() {
        initWidget(uiBinder.createAndBindUi(this));
        searchBox.getElement().setPropertyString("placeholder", cst.searchAlgorithms());
    }

    interface HeaderUiBinder extends UiBinder<Widget, Header> {
    }
}
