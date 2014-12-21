package com.sbk.algo.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Created by sobik on 31/08/2014.
 */
public class SearchPlace extends Place {

    private static final String VIEW_HISTORY_TOKEN = "search";

    public SearchPlace() {
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<SearchPlace> {
        @Override
        public SearchPlace getPlace(String token) {
            return new SearchPlace();
        }

        @Override
        public String getToken(SearchPlace place) {
            return "";
        }
    }
}
