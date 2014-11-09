package com.sbk.algo.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Created by sobik on 09/11/2014.
 */
public class SortHeapPlace extends Place {
    private static final String VIEW_HISTORY_TOKEN = "sortHeap";

    public SortHeapPlace() {
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<SortHeapPlace> {
        @Override
        public SortHeapPlace getPlace(String token) {
            return new SortHeapPlace();
        }

        @Override
        public String getToken(SortHeapPlace place) {
            return "";
        }
    }
}
