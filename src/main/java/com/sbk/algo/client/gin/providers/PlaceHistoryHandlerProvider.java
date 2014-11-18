package com.sbk.algo.client.gin.providers;

import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;


/**
 * Created by sobik on 28/10/2014.
 */
public class PlaceHistoryHandlerProvider implements Provider<PlaceHistoryHandler> {

    final private PlaceHistoryHandler placeHistoryHandler;

    @Inject
    public PlaceHistoryHandlerProvider(PlaceHistoryMapper historyMapper) {
        this.placeHistoryHandler = new PlaceHistoryHandler(historyMapper);
    }

    @Override
    public PlaceHistoryHandler get() {
        return placeHistoryHandler;
    }

}
