package com.twotoasters.hellostudio;

import android.app.Activity;
import android.view.View.MeasureSpec;

import com.twotoasters.hellostudio.BlankActivity;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class BlankActivityTest {

    BlankActivity activity;

    @Before public void setUp() throws Exception {
        activity = new BlankActivity();
        activity.onCreate(null);
    }

    @Test public void testNotNull() {
        assertThat(activity).isNotNull();
    }

    @Test public void testGetCurrentTimestamp() {
        long timestamp = activity.getCurrentTimestamp();
        Assertions.assertThat(timestamp).isGreaterThan(0);
    }
}
