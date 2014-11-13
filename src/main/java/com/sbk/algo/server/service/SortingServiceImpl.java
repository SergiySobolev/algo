package com.sbk.algo.server.service;

import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sbk.algo.client.service.SortingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * Created by sobik on 11/11/2014.
 */
@Service("sortingService")
@Transactional
public class SortingServiceImpl extends RemoteServiceServlet implements SortingService {

    Random rnd = new Random();
    private List<Integer> genList = Lists.newArrayList();
    private List<Integer> sortedList = Lists.newArrayList();

    @Override
    //TODO add optional to ret type
    public List<Integer> generate(Integer capacity) {
        genList.clear();
        for (int i = 0; i < capacity; i++) {
            genList.add(rnd.nextInt(capacity * 3));
        }
        return genList;
    }

    @Override
    public List<Integer> sort() {
        sortedList.clear();
        sortedList.addAll(genList);
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

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
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