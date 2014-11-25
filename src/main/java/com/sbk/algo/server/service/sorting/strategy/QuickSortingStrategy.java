package com.sbk.algo.server.service.sorting.strategy;

import com.sbk.algo.shared.enums.SortingType;

import java.util.List;

/**
 * Created by sobik on 20/11/2014.
 */
@SortStrategy(sortingType = SortingType.QUICK)
public class QuickSortingStrategy extends AbstractSortingStrategy {

    @Override
    public List<Integer> sort(List<Integer> l) {
        return quicksort(l, 0, l.size() - 1);
    }

    private List<Integer> quicksort(List<Integer> list, int first, int last) {
        if (first < last) {
            int pivot = first + (last - first) / 2;
            Integer pivotElement = list.get(pivot);
            int i = first;
            int j = last;
            while (i <= j) {
                while (list.get(i) < pivotElement) i++;
                while (list.get(j) > pivotElement) j--;
                if (i <= j) {
                    this.swap(list, i, j);
                    i++;
                    j--;
                }
            }
            if (first < j) {
                quicksort(list, first, j);
            }
            if (i < last) {
                quicksort(list, i, last);
            }
        }
        return list;
    }
}
