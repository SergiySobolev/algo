package com.sbk.algo.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface SearchServiceAsync {
    void generate(Integer capacity, AsyncCallback<List<Integer>> async);

    void findMax(AsyncCallback<Integer> async);
}
