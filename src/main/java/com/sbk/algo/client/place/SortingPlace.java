package com.sbk.algo.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Created by sobik on 31/08/2014.
 */
public class SortingPlace extends Place {
    private static final String VIEW_HISTORY_TOKEN = "sort";

    public SortingPlace() {
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<SortingPlace> {
        @Override
        public SortingPlace getPlace(String token) {
            return new SortingPlace();
        }

        @Override
        public String getToken(SortingPlace place) {
            return "";
        }
    }
}
