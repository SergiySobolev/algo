package com.sbk.algo.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Created by sobik on 31/08/2014.
 */
public class GraphPlace extends Place {
    private static final String VIEW_HISTORY_TOKEN = "graph";

    public GraphPlace() {
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<GraphPlace> {
        @Override
        public GraphPlace getPlace(String token) {
            return new GraphPlace();
        }

        @Override
        public String getToken(GraphPlace place) {
            return "";
        }
    }
}
