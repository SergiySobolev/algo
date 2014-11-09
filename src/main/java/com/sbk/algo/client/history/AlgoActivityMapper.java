package com.sbk.algo.client.history;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.sbk.algo.client.activity.GraphActivity;
import com.sbk.algo.client.activity.SortHeapActivity;
import com.sbk.algo.client.activity.SortingActivity;
import com.sbk.algo.client.place.GraphPlace;
import com.sbk.algo.client.place.SortHeapPlace;
import com.sbk.algo.client.place.SortingPlace;

public class AlgoActivityMapper implements ActivityMapper {

    @Inject
    private SortingActivity sortingActivity;

    @Inject
    private GraphActivity graphActivity;

    @Inject
    private SortHeapActivity sortHeapActivity;

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof SortingPlace) {
            return sortingActivity;
        } else if (place instanceof GraphPlace) {
            return graphActivity;
        } else if (place instanceof SortHeapPlace) {
            return sortHeapActivity;
        }
        return null;
    }
}
