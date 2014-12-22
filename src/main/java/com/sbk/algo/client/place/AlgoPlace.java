package com.sbk.algo.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.sbk.algo.client.history.AlgoMapperVisitor;

/**
 * Created by sobik on 22/12/2014.
 */
public abstract class AlgoPlace extends Place {
    public abstract Activity accept(AlgoMapperVisitor visitor);
}
