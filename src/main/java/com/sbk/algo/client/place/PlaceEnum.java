package com.sbk.algo.client.place;

import com.google.gwt.place.shared.Place;

/**
 * Created by sobik on 21/12/2014.
 */
public enum PlaceEnum {
    SORT() {
        public Place getPlace() {
            return new SortingPlace();
        }
    },
    SEARCH() {
        public Place getPlace() {
            return new SearchPlace();
        }
    },
    GRAPH() {
        public Place getPlace() {
            return new GraphPlace();
        }
    };

    public abstract Place getPlace();
}
