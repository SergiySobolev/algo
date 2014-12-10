package com.sbk.algo.server.service.sorting.strategy;

import com.google.common.collect.Lists;
import com.sbk.algo.shared.enums.SortingType;

import java.util.Collections;
import java.util.List;

/**
 * Created by sobik on 20/11/2014.
 */
@SortStrategy(sortingType = SortingType.BUCKET)
public class BucketSortingStrategy extends AbstractSortingStrategy {


    @Override
    public List<Integer> sort(List<Integer> l) {
        Integer k = Collections.max(l);
        return bucketSort(l, k);
    }

    private List<Integer> bucketSort(List<Integer> l, Integer maxElement) {
        List<Integer> buckets = Lists.newArrayList();
        for (int i = 0; i < maxElement + 1; i++) {
            buckets.add(0);
        }
        for (Integer i : l) {
            buckets.set(i, buckets.get(i) + 1);
        }
        List<Integer> res = Lists.newArrayList();
        for (int i = 1; i < buckets.size(); i++) {
            for (int j = 0; j < buckets.get(i); j++) {
                res.add(i);
            }
        }
        return res;

    }

}
