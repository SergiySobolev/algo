package com.sbk.algo.client.history;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.sbk.algo.client.place.AlgoPlace;

public class AlgoActivityMapper implements ActivityMapper {

    @Inject
    private AlgoMapperVisitor visitor;

    @Override
    public Activity getActivity(Place place) {
        return ((AlgoPlace) place).accept(visitor);
    }
}
