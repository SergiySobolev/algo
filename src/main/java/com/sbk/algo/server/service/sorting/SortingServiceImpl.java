package com.sbk.algo.server.service.sorting;

import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sbk.algo.client.service.SortingService;
import com.sbk.algo.server.service.sorting.strategy.SortingStrategy;
import com.sbk.algo.server.service.sorting.strategy.SortingStrategyFactory;
import com.sbk.algo.shared.enums.SortingType;
import com.sbk.algo.shared.result.SortingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service("sortingService")
@Transactional
public class SortingServiceImpl extends RemoteServiceServlet implements SortingService {

    Random rnd = new Random();
    private List<Integer> genList = Lists.newArrayList();

    @Autowired
    @Qualifier(value = "sortingStrategyFactory")
    private SortingStrategyFactory strategyFactory;

    @Override
    public List<Integer> generate(Integer capacity) {
        genList.clear();
        for (int i = 0; i < capacity; i++) {
            genList.add(rnd.nextInt(capacity * 3));
        }
        return genList;
    }

    @Override
    public SortingResult sort(SortingType sortingType) {
        SortingStrategy strategy = strategyFactory.getStrategy(sortingType);
        SortingResult ret = new SortingResult();
        final List<Integer> sortedList = strategy.sort(genList);
        ret.setResult(sortedList);
        return ret;
    }


}