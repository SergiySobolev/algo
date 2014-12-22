package com.sbk.algo.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.sbk.algo.client.history.AlgoMapperVisitor;

/**
 * Created by sobik on 31/08/2014.
 */
public class SearchPlace extends AlgoPlace {

    private static final String VIEW_HISTORY_TOKEN = "search";

    public Activity accept(AlgoMapperVisitor visitor) {
        return visitor.visit(this);
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
