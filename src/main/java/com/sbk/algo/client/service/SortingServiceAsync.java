package com.sbk.algo.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by sobik on 11/11/2014.
 */
public interface SortingServiceAsync {

    void generate(Integer capacity, AsyncCallback<List<Integer>> async);

    void sort(AsyncCallback<List<Integer>> async);
}
