package com.sbk.algo.client.context;


import com.sbk.algo.shared.dto.AlgoUser;

public class Context {

    private static AlgoUser user;

    public static AlgoUser getAlgoUser() {
        return user;
    }

    public static void setAlgoUser(AlgoUser algoUser) {
        user = algoUser;
    }

}
