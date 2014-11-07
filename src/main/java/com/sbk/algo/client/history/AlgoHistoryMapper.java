package com.sbk.algo.client.history;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.sbk.algo.client.place.SortingPlace;

@WithTokenizers({SortingPlace.Tokenizer.class})
public interface AlgoHistoryMapper extends PlaceHistoryMapper {
}
