package com.sbk.algo.server.service.sorting.strategy;

import com.google.common.collect.Lists;
import com.sbk.algo.shared.enums.SortingType;

import java.util.List;

/**
 * Created by sobik on 18/11/2014.
 */
@SortStrategy(sortingType = SortingType.HEAP)
public class HeapSortingStrategy extends AbstractSortingStrategy {

    private List<Integer> sortedList = Lists.newArrayList();

    @Override
    public List<Integer> sort(List<Integer> listToSort) {
        sortedList.clear();
        sortedList.addAll(listToSort);
        this.buildMapHeap(sortedList, sortedList.size());
        int heapSize = sortedList.size();
        for (int i = sortedList.size(); i > 0; i--) {
            swap(sortedList, i - 1, 0);
            heapSize--;
            this.mapHeapify(sortedList, 0, heapSize);
        }
        return sortedList;

    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return left(i) + 1;
    }

    private void mapHeapify(List<Integer> list, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest;

        if (l < heapSize && list.get(l) > list.get(i)) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapSize && list.get(r) > list.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            this.swap(list, largest, i);
            mapHeapify(list, largest, heapSize);
        }
    }

    private void buildMapHeap(List<Integer> list, int heapSize) {
        for (int i = (heapSize >> 1); i >= 0; i--) {
            mapHeapify(list, i, heapSize);
        }
    }
}
