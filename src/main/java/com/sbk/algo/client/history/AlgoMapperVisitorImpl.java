package com.sbk.algo.client.history;

import com.google.gwt.activity.shared.Activity;
import com.google.inject.Inject;
import com.sbk.algo.client.activity.GraphActivity;
import com.sbk.algo.client.activity.SearchActivity;
import com.sbk.algo.client.activity.SortingActivity;
import com.sbk.algo.client.activity.SortingFacadeActivity;
import com.sbk.algo.client.place.GraphPlace;
import com.sbk.algo.client.place.SearchPlace;
import com.sbk.algo.client.place.SortingPlace;

/**
 * Created by sobik on 22/12/2014.
 */
public class AlgoMapperVisitorImpl implements AlgoMapperVisitor {

    @Inject
    private SortingFacadeActivity sortingFacadeActivity;

    @Inject
    private SortingActivity sortingActivity;

    @Inject
    private SearchActivity searchActivity;

    @Inject
    private GraphActivity graphActivity;

    @Override
    public Activity visit(SortingPlace place) {
        if (place.getSortingType() == null) {
            return sortingFacadeActivity;
        } else {
            sortingActivity.setSortingType(place.getSortingType());
            return sortingActivity;
        }
    }

    @Override
    public Activity visit(SearchPlace place) {
        return searchActivity;
    }

    @Override
    public Activity visit(GraphPlace place) {
        return graphActivity;
    }
}
