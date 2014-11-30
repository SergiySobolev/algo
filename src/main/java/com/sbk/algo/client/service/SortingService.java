package com.sbk.algo.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sbk.algo.shared.enums.SortingType;
import com.sbk.algo.shared.result.SortingResult;

import java.util.List;

/**
 * Created by sobik on 11/11/2014.
 */
@RemoteServiceRelativePath("algoserv/sortingService")
public interface SortingService extends RemoteService {

    List<Integer> generate(Integer capacity);

    SortingResult sort(SortingType sortingType);

}
