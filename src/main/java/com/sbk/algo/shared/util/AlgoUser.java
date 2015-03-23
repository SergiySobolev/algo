package com.sbk.algo.shared.util;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AlgoUser implements IsSerializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
