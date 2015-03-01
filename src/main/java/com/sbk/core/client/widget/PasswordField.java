package com.sbk.core.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;

public class PasswordField extends Composite {

    private static PasswordFieldUiBinder uiBinder = GWT.create(PasswordFieldUiBinder.class);
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Label label;

    public PasswordField() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setLabel(String text) {
        label.setText(text);
    }

    public String getText() {
        return passwordBox.getText();
    }

    @UiTemplate("PasswordField.ui.xml")
    interface PasswordFieldUiBinder extends UiBinder<Widget, PasswordField> {
    }
}
