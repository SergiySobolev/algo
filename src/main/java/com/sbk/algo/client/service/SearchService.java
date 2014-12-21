package com.sbk.algo.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by sobik on 21/12/2014.
 */
@RemoteServiceRelativePath("algoserv/searchService")
public interface SearchService extends RemoteService {

    List<Integer> generate(Integer capacity);

    Integer findMax();
}
