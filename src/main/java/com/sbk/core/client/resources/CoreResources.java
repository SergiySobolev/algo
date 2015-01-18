package com.sbk.core.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by sobik on 08/10/2014.
 */
public interface CoreResources extends ClientBundle {

    @Source("images/loading.gif")
    ImageResource loading();

    @Source("css/core.css")
    public CoreCSS coreCSS();

}
