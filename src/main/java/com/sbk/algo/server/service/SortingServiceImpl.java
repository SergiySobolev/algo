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

    List<Integer> genList = Lists.newArrayList();

    List<Integer> sortedList = Lists.newArrayList();

    Random rnd = new Random();

    @Override
    //TODO add optional to ret type
    public List<Integer> generate(Integer capacity) {
        genList.clear();
        for (int i = 0; i < capacity; i++) {
            genList.add(rnd.nextInt(capacity));
        }
        return genList;
    }

    @Override
    public List<Integer> sort() {
        sortedList.clear();
        sortedList.addAll(genList);
        return sortedList;
    }
}