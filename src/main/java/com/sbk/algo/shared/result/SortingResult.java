package com.sbk.algo.shared.result;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.List;

/**
 * Created by sobik on 30/11/2014.
 */
public class SortingResult implements IsSerializable {

    private Chronometr chrono;
    private List<Integer> result;

    public SortingResult() {
    }


    public Chronometr getChrono() {
        return chrono;
    }

    public void setChrono(Chronometr chrono) {
        this.chrono = chrono;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
