package com.sbk.algo.server.service.sorting.strategy;

import com.sbk.algo.shared.enums.SortingType;

import java.util.List;

/**
 * Created by sobik on 02/12/2014.
 */
@SortStrategy(sortingType = SortingType.MERGE)
public class MergeSortingStrategy extends AbstractSortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> listToSort) {
        return mergeSort(listToSort, 0, listToSort.size() - 1);
    }

    private List<Integer> mergeSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(list, low, mid);
            mergeSort(list, mid + 1, high);
            this.merge(list, low, mid, high);
        }
        return list;
    }
}
