package com.sbk.algo.client.localization;

import com.google.gwt.i18n.client.Messages;

public interface AlgoMessages extends Messages {

    @DefaultMessage("User {0} logged in successfully")
    String loginSucceed(String userName);

    @DefaultMessage("User {0} logged out")
    String logout(String userName);

    @DefaultMessage("Login failure")
    String loginFailure();
}
