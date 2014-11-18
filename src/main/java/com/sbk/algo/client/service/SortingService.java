package com.sbk.algo.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sbk.algo.shared.enums.SortingType;

import java.util.List;

/**
 * Created by sobik on 11/11/2014.
 */
@RemoteServiceRelativePath("algoserv/sortingService")
public interface SortingService extends RemoteService {

    List<Integer> generate(Integer capacity);

    List<Integer> sort(SortingType sortingType);

    /**
     * Utility/Convenience class.
     * Use SortingService.App.getInstance() to access static instance of SortingServiceAsync
     */
    public static class App {
        private static final SortingServiceAsync ourInstance = (SortingServiceAsync) GWT.create(SortingService.class);

        public static SortingServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
