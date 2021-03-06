package com.sbk.core.client.widget;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.sbk.core.client.resources.CoreResources;

import static com.sbk.core.client.gin.CoreInjector.INSTANCE;

public class CloseablePopupPanel extends DialogBox {

    CoreResources coreResources = INSTANCE.getCoreResources();

    Anchor close = new Anchor("[X]");
    HTML title = new HTML("");
    HorizontalPanel captionPanel = new HorizontalPanel();

    public CloseablePopupPanel(boolean autoHide, boolean modal) {
        super(autoHide, modal);
        Element td = getCellElement(0, 1);
        DOM.removeChild(td, (Element) td.getFirstChildElement());
        DOM.appendChild(td, captionPanel.getElement());
        captionPanel.setStyleName(coreResources.coreCSS().dialogBoxCaption());
        captionPanel.add(title);
        close.addStyleName(coreResources.coreCSS().floatRight());
        captionPanel.add(close);
        super.setGlassEnabled(true);
        super.setAnimationEnabled(true);
    }

    public CloseablePopupPanel(boolean autoHide) {
        this(autoHide, true);
    }

    public CloseablePopupPanel() {
        this(false);
    }

    @Override
    public String getHTML() {
        return this.title.getHTML();
    }

    @Override
    public void setHTML(String html) {
        this.title.setHTML(html);
    }

    @Override
    public String getText() {
        return this.title.getText();
    }

    @Override
    public void setText(String text) {
        this.title.setText(text);
    }

    @Override
    protected void onPreviewNativeEvent(Event.NativePreviewEvent event) {
        NativeEvent nativeEvent = event.getNativeEvent();

        if (!event.isCanceled()
                && (event.getTypeInt() == Event.ONCLICK)
                && isCloseEvent(nativeEvent)) {
            this.hide();
        }
        super.onPreviewNativeEvent(event);
    }

    private boolean isCloseEvent(NativeEvent event) {
        return event.getEventTarget().equals(close.getElement());//compares equality of the underlying DOM elements
    }
}
