package com.sbk.algo.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


/**
 * Created by sobik on 03/11/2014.
 */
public class NavigationMenu extends Composite {
    private static NavigationMenuUiBinder uiBinder = GWT.create(NavigationMenuUiBinder.class);

    public NavigationMenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface NavigationMenuUiBinder extends UiBinder<Widget, NavigationMenu> {
    }

}
