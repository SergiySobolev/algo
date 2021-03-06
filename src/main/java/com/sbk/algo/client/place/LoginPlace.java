package com.sbk.algo.client.place;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.sbk.algo.client.history.AlgoMapperVisitor;


public class LoginPlace extends AlgoPlace {
    private static final String VIEW_HISTORY_TOKEN = "login";

    public LoginPlace() {
    }

    public Activity accept(AlgoMapperVisitor visitor) {
        return visitor.visit(this);
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
        @Override
        public LoginPlace getPlace(String token) {
            return new LoginPlace();
        }

        @Override
        public String getToken(LoginPlace place) {
            return "";
        }
    }
}
