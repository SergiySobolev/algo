package com.sbk.algo.client.localization;

import com.google.gwt.i18n.client.Constants;

/**
 * Created by sobik on 09/10/2014.
 */
public interface AlgoConstants extends Constants {

    @DefaultStringValue("Algorithms")
    String algorithms();

    @DefaultStringValue("Sorting")
    String sorting();

    @DefaultStringValue("Graph")
    String graphs();

    @DefaultStringValue("Matrix")
    String matrix();

    @DefaultStringValue("Search for algorithms...")
    String searchAlgorithms();

    @DefaultStringValue("Heap sort")
    String heapSort();

    @DefaultStringValue("Quick sort")
    String quickSort();

    @DefaultStringValue("Merge sort")
    String mergeSort();

    @DefaultStringValue("Jung sort")
    String jungSort();

    @DefaultStringValue("Bucket sort")
    String bucketSort();

    @DefaultStringValue("Input data:")
    String inputData();

    @DefaultStringValue("Output data:")
    String outputData();

    @DefaultStringValue("Generate")
    String generate();

    @DefaultStringValue("Sort")
    String sort();

    @DefaultStringValue("Time Elapsed")
    String timeElapsed();
}
