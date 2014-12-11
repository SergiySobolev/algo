package com.sbk.algo.server.service.sorting.strategy;

import com.google.common.collect.Lists;
import com.sbk.algo.shared.enums.SortingType;

import java.util.List;

/**
 * Created by sobik on 18/11/2014.
 */
@SortStrategy(sortingType = SortingType.RADIX)
public class RadixSortingStrategy extends AbstractSortingStrategy {

    private List<Integer> sortedList = Lists.newArrayList();

    @Override
    public List<Integer> sort(List<Integer> l) {
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {

            List<Integer> tmp = Lists.newArrayList();

            for (int i = 0; i < l.size(); i++) {
                tmp.add(0);
            }

            int j = 0;

            for (int i = 0; i < l.size(); i++) {
                boolean move = l.get(i) << shift >= 0;
                if (shift == 0 ? !move : move) {
                    tmp.set(j, l.get(i));
                    j++;
                } else {
                    l.set(i - j, l.get(i));
                }
            }

            // Copy over the 1s from the old array
            for (int i = j; i < tmp.size(); i++) {
                tmp.set(i, l.get(i - j));
            }

            // And now the tmp array gets switched for another round of sorting
            l = tmp;
        }
        return l;
    }
}
