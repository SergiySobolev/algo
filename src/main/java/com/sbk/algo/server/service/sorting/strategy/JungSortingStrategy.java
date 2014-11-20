package com.sbk.algo.server.service.sorting.strategy;

import com.google.common.collect.Lists;
import com.sbk.algo.shared.enums.SortingType;

import java.util.List;

/**
 * Created by sobik on 20/11/2014.
 */
@SortStrategy(sortingType = SortingType.JUNG)
public class JungSortingStrategy extends AbstractSortingStrategy {

    @Override
    public List<Integer> sort(List<Integer> l) {
        List<Integer> jungTable = this.buildJungTable(l);
        return this.sortWithJungTable(jungTable);
    }

    private List<Integer> buildJungTable(List<Integer> l) {
        int m = (int) Math.ceil(Math.sqrt(l.size()));
        List<Integer> jungTable = Lists.newArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int current = this.calcIndex(i, j, m);
                if (current < l.size()) {
                    jungTable.add(current, l.get(current));
                    this.moveUp(jungTable, i, j, m);
                }
            }
        }
        return jungTable;
    }

    private List<Integer> sortWithJungTable(List<Integer> jungTable) {
        int m = (int) Math.ceil(Math.sqrt(jungTable.size()));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int current = this.calcIndex(i, j, m);
                if (current < jungTable.size()) {
                    this.swap(jungTable, 0, jungTable.size() - 1 - current);
                    this.moveDown(jungTable, i, j, m);
                }
            }
        }
        return jungTable;
    }

    private void moveUp(List<Integer> l, int i, int j, int m) {
        while (true) {
            boolean biggerThanLeft = false, biggerThanTop = false;
            int current = this.calcIndex(i, j, m);
            int left = 0;
            int top = 0;
            if (i > 0) {
                top = this.calcIndex(i - 1, j, m);
                biggerThanTop = l.get(top) < l.get(current);
            }
            if (j > 0) {
                left = this.calcIndex(i, j - 1, m);
                biggerThanLeft = l.get(left) < l.get(current);
            }
            if (biggerThanLeft || biggerThanTop) {
                if (biggerThanLeft && biggerThanTop) {
                    if (l.get(top) < l.get(left)) {
                        biggerThanLeft = false;
                    } else {
                        biggerThanTop = false;
                    }
                }
                if (biggerThanLeft) {
                    this.swap(l, left, current);
                    j -= 1;

                }
                if (biggerThanTop) {
                    this.swap(l, top, current);
                    i -= 1;

                }
            } else {
                break;
            }
        }
    }

    private void moveDown(List<Integer> l, int row, int col, int m) {
        int i = 0;
        int j = 0;
        int idxToMove = this.calcIndex(row, col, m);
        while (true) {
            boolean lesserThanRight = false, lesserThanBot = false;
            int current = this.calcIndex(i, j, m);
            int right = 0;
            int bot = 0;
            if ((this.calcIndex(i + 1, j, m) < l.size() - idxToMove - 1) && i + 1 < m) {
                bot = this.calcIndex(i + 1, j, m);
                lesserThanBot = l.get(bot) > l.get(current);
            }
            if ((this.calcIndex(i, j + 1, m) < l.size() - idxToMove - 1) && j + 1 < m) {
                right = this.calcIndex(i, j + 1, m);
                lesserThanRight = l.get(right) > l.get(current);
            }
            if (lesserThanRight || lesserThanBot) {
                if (lesserThanRight && lesserThanBot) {
                    if (l.get(bot) > l.get(right)) {
                        lesserThanRight = false;
                    } else {
                        lesserThanBot = false;
                    }
                }
                if (lesserThanRight) {
                    this.swap(l, right, current);
                    j += 1;

                }
                if (lesserThanBot) {
                    this.swap(l, bot, current);
                    i += 1;

                }
            } else {
                break;
            }
        }

    }

    private int calcIndex(int i, int j, int m) {
        return i * m + j;
    }
}
