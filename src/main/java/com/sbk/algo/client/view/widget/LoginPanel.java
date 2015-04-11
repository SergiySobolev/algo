package com.sbk.algo.client.view.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.core.client.widget.PasswordField;
import com.sbk.core.client.widget.TextField;


public class LoginPanel extends Composite {

    private static LoginPanelUiBinder uiBinder = GWT.create(LoginPanelUiBinder.class);
    @UiField
    TextField userName;
    @UiField
    PasswordField password;
    @UiField
    Button okButton;
    @UiField
    Button cancelButton;

    public LoginPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void addOkClickHandler(ClickHandler okButtonClickHandler) {
        okButton.addClickHandler(okButtonClickHandler);
    }

    public void addCancelClickHandler(ClickHandler cancelButtonClickHandler) {
        cancelButton.addClickHandler(cancelButtonClickHandler);
    }

    public String getLogin() {
        return userName.getText();
    }

    public String getPassword() {
        return password.getText();
    }


    @UiTemplate("LoginPanel.ui.xml")
    interface LoginPanelUiBinder extends UiBinder<Widget, LoginPanel> {
    }


}
