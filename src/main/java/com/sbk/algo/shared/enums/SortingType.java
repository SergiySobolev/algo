package com.sbk.algo.shared.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sobik on 17/11/2014.
 */
public enum SortingType {
    HEAP("heap"),
    QUICK("quick"),
    MERGE("merge"),
    JUNG("jung"),
    BUCKET("bucket"),
    RADIX("radix");

    private static final Map<String, SortingType> lookup = new HashMap<String, SortingType>();

    static {
        for (SortingType st : SortingType.values())
            lookup.put(st.getCode(), st);
    }

    private String code;

    SortingType(String code) {
        this.code = code;
    }

    public static SortingType find(String code) {
        return lookup.get(code);
    }

    public String getCode() {
        return code;
    }
}
