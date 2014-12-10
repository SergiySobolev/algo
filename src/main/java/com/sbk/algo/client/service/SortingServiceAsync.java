package com.sbk.algo.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sbk.algo.shared.enums.SortingType;
import com.sbk.algo.shared.result.SortingResult;

import java.util.List;

/**
 * Created by sobik on 11/11/2014.
 */
public interface SortingServiceAsync {

    void generate(Integer capacity, AsyncCallback<List<Integer>> async);

    void sort(SortingType sortingType, AsyncCallback<SortingResult> async);
}
