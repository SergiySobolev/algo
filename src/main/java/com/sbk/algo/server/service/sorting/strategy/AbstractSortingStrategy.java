package com.sbk.algo.server.service.sorting.strategy;

import com.google.common.collect.Lists;

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

    protected void merge(List<Integer> list, int low, int mid, int high) {
        List<Integer> tempArray = Lists.newArrayList(list);
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tempArray.get(i) < tempArray.get(j)) {
                list.set(k, tempArray.get(i));
                i++;
                k++;
            } else {
                list.set(k, tempArray.get(j));
                j++;
                k++;
            }
        }
        while (i <= mid) {
            list.set(k, tempArray.get(i));
            k++;
            i++;
        }
    }

}
