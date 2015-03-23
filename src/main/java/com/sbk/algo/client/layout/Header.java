package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Header extends Composite {
    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    @UiField
    TextBox searchBox;

    public Header() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setSearchPlaceHolder(String placeHolder) {
        searchBox.getElement().setPropertyString("placeholder", placeHolder);
    }

    interface HeaderUiBinder extends UiBinder<Widget, Header> {
    }
}
