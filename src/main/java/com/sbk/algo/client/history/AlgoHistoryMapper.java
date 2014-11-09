package com.sbk.algo.client.history;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.sbk.algo.client.place.GraphPlace;
import com.sbk.algo.client.place.SortHeapPlace;
import com.sbk.algo.client.place.SortingPlace;

@WithTokenizers({SortingPlace.Tokenizer.class,
        GraphPlace.Tokenizer.class,
        SortHeapPlace.Tokenizer.class})
public interface AlgoHistoryMapper extends PlaceHistoryMapper {
}
