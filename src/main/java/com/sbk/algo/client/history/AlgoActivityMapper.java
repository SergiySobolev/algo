package com.sbk.algo.client.history;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.sbk.algo.client.activity.SortingActivity;
import com.sbk.algo.client.place.SortingPlace;

public class AlgoActivityMapper implements ActivityMapper {
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof SortingPlace) {
            return new SortingActivity();
        }
        return null;
    }
}
