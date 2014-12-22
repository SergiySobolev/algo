package com.sbk.algo.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.sbk.algo.client.history.AlgoMapperVisitor;
import com.sbk.algo.shared.enums.SortingType;

/**
 * Created by sobik on 31/08/2014.
 */
public class SortingPlace extends AlgoPlace {

    private static final String VIEW_HISTORY_TOKEN = "sort";

    private SortingType sortingType;

    public SortingPlace() {

    }

    public SortingPlace(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public Activity accept(AlgoMapperVisitor visitor) {
        return visitor.visit(this);
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<SortingPlace> {
        @Override
        public SortingPlace getPlace(String token) {
            return new SortingPlace(SortingType.find(token));
        }

        @Override
        public String getToken(SortingPlace place) {
            return place.getSortingType() != null ? place.getSortingType().getCode() : "";
        }
    }
}
