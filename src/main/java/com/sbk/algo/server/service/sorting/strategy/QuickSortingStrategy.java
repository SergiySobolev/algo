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
        return quicksortTwo(l, 0, l.size() - 1);
    }

    private List<Integer> quicksortTwo(List<Integer> l, int first, int last) {
        Integer pivot = l.get(last);
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (l.get(j) <= pivot) {
                i++;
                swap(l, i, j);
            }
        }
        swap(l, i + 1, last);
        if (i > first) {
            quicksortTwo(l, first, i);
        }
        if (i + 2 < last) {
            quicksortTwo(l, i + 2, last);
        }
        return l;
    }

    private List<Integer> quicksortOne(List<Integer> list, int first, int last) {
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
                quicksortOne(list, first, j);
            }
            if (i < last) {
                quicksortOne(list, i, last);
            }
        }
        return list;
    }
}
