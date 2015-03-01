package com.sbk.core.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TextField extends Composite {

    private static TextFieldUiBinder uiBinder = GWT.create(TextFieldUiBinder.class);
    @UiField
    TextBox textBox;
    @UiField
    Label label;

    public TextField() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setLabel(String text) {
        label.setText(text);
    }

    public String getText() {
        return textBox.getText();
    }


    @UiTemplate("TextField.ui.xml")
    interface TextFieldUiBinder extends UiBinder<Widget, TextField> {
    }
}
