package algo.sorting;


import com.google.common.collect.Lists;
import com.sbk.algo.client.service.SortingService;
import com.sbk.algo.config.WebAppConfig;
import com.sbk.algo.config.WebAppInitializer;
import com.sbk.algo.shared.enums.SortingType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertTrue;

/**
 * Created by sobik on 12/11/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppInitializer.class, WebAppConfig.class})
public class SortingTest {

    @Autowired
    SortingService sortingService;

    private List<Integer> sortedList, testList;

    @Before
    public void init() {
        sortedList = Lists.newArrayList(13, 1, 9, 18, 19, 1, 4, 7, 1, 8);
        testList = Lists.newArrayList(sortedList);
    }

    private List<Integer> generateList(int size) {
        List<Integer> l = Lists.newArrayList();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            l.add(rnd.nextInt(size * 2));
        }
        return l;
    }

    private boolean testSortedAscEqual(List<Integer> l) {
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i) > l.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testHeapSort() {
        assertTrue(testSortedAscEqual(sortingService.sort(SortingType.HEAP).getResult()));
    }
}
