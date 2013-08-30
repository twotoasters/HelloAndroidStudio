package com.twotoasters.hellostudio;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class SimpleActivityTest {

    SimpleActivity activity;

    @Before public void setUp() throws Exception {
        SimpleActivity activity = new SimpleActivity();
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
