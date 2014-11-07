package com.sbk.algo.client.gin.providers;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Created by sobik on 07/11/2014.
 */
public class ActivityManagerProvider implements Provider<ActivityManager> {
    private final ActivityManager activityManager;

    @Inject
    public ActivityManagerProvider(ActivityMapper activityMapper, EventBus eventBus) {
        this.activityManager = new ActivityManager(activityMapper, eventBus);
    }

    @Override
    public ActivityManager get() {
        return this.activityManager;
    }
}
