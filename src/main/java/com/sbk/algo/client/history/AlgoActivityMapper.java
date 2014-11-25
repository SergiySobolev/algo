package com.sbk.algo.client.history;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.sbk.algo.client.activity.GraphActivity;
import com.sbk.algo.client.activity.SortingActivity;
import com.sbk.algo.client.activity.SortingFacadeActivity;
import com.sbk.algo.client.place.SortingPlace;

public class AlgoActivityMapper implements ActivityMapper {

    @Inject
    private SortingFacadeActivity sortingFacadeActivity;

    @Inject
    private SortingActivity sortingActivity;

    @Inject
    private GraphActivity graphActivity;

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof SortingPlace) {
            SortingPlace sortingPlace = (SortingPlace) place;
            if (sortingPlace.getSortingType() == null) {
                return sortingFacadeActivity;
            } else {
                sortingActivity.setSortingType(sortingPlace.getSortingType());
                return sortingActivity;
            }
        }
        return null;
    }
}
