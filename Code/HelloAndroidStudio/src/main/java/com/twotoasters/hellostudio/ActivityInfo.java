package com.twotoasters.hellostudio;

import android.app.Activity;

class ActivityInfo {
    public final Class<? extends Activity> activityClass;
    public final int titleResourceId;

    public ActivityInfo(Class<? extends Activity> activityClass, int titleResourceId) {
        this.activityClass = activityClass;
        this.titleResourceId = titleResourceId;
    }
}
