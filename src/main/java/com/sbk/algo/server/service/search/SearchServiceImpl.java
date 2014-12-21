package com.sbk.algo.server.service.search;

import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sbk.algo.client.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * Created by sobik on 21/12/2014.
 */
@Service("searchService")
@Transactional
public class SearchServiceImpl extends RemoteServiceServlet implements SearchService {

    Random rnd = new Random();
    private List<Integer> genList = Lists.newArrayList();

    @Override
    public List<Integer> generate(Integer capacity) {
        genList.clear();
        for (int i = 0; i < capacity; i++) {
            genList.add(rnd.nextInt(capacity * 3));
        }
        return genList;
    }

    @Override
    public Integer findMax() {
        Integer max = genList.get(0);
        for (int i = 1; i < genList.size(); i++) {
            if (genList.get(i) > max) {
                max = genList.get(i);
            }
        }
        return max;
    }
}
