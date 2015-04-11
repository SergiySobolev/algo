package com.sbk.core.client.widget;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.Duration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.sbk.core.client.resources.CoreResources;

import static com.sbk.core.client.gin.CoreInjector.INSTANCE;

class FadingPanel extends PopupPanel {
    private final int ANIMATION_DURATION = 2000;
    protected CoreResources coreResources = INSTANCE.getCoreResources();
    private boolean autoHide = true;
    private boolean modal = true;
    private String width = "200";
    private String height = "70";

    protected FadingPanel(String message) {
        new FadingPanel(autoHide, modal);
        super.setGlassEnabled(true);
        super.setAnimationEnabled(true);
        setAutoHideEnabled(true);
        HorizontalPanel content = new HorizontalPanel();
        Label w = new Label(message);
        w.addStyleName(coreResources.coreCSS().textCenter());
        content.add(w);
        content.setCellVerticalAlignment(w, HorizontalPanel.ALIGN_MIDDLE);
        add(content);
        setSize(width, height);
    }

    private FadingPanel(boolean autoHide, boolean modal) {
        super(autoHide, modal);
    }

    @Override
    public void show() {
        FadingAnimation animation = new FadingAnimation();
        animation.run(ANIMATION_DURATION);
        super.show();
        if (autoHide) {
            FadingAnimation hideAnimation = new FadingAnimation(false);
            // run hide animation after some time
            hideAnimation.run(ANIMATION_DURATION, Duration.currentTimeMillis() + ANIMATION_DURATION);
            // when animation will end, the widget must be hidden
            Timer timer = new Timer() {
                @Override
                public void run() {
                    FadingPanel.this.hide();
                }
            };
        }
    }

    private class FadingAnimation extends Animation {
        boolean show = true;

        FadingAnimation(boolean show) {
            super();
            this.show = show;
        }

        public FadingAnimation() {
            this(true);
        }

        @Override
        protected void onUpdate(double progress) {
            double opacityValue = progress;

            if (!show) {
                opacityValue = 1.0 - progress;
            }

            FadingPanel.this.getElement().getStyle().setOpacity(opacityValue);
        }
    }
}


