package com.sbk.algo.client.history;

import com.google.gwt.activity.shared.Activity;
import com.sbk.algo.client.place.GraphPlace;
import com.sbk.algo.client.place.SearchPlace;
import com.sbk.algo.client.place.SortingPlace;

/**
 * Created by sobik on 22/12/2014.
 */
public interface AlgoMapperVisitor {
    Activity visit(SortingPlace place);

    Activity visit(SearchPlace place);

    Activity visit(GraphPlace place);
}
