package com.sbk.algo.server.service.sorting.strategy;

import java.util.List;

/**
 * Created by sobik on 20/11/2014.
 */
public abstract class AbstractSortingStrategy implements SortingStrategy {
    protected void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
