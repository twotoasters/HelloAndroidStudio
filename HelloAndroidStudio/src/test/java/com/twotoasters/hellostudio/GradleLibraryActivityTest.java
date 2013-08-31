package com.twotoasters.hellostudio;

import android.app.Activity;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

import com.twotoasters.hellostudio.GradleLibraryActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class GradleLibraryActivityTest {

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /*
     * Causes tests to not build due to gradle android test plugin issue #7
     */
    @Test public void testSetupPullAttacher() {
        /*
        GradleLibraryActivity activity = new GradleLibraryActivity();
        assertThat(activity).isNotNull();

        activity.onCreate(null);

        assertThat(activity.setupPullToRefresh()).isNotNull();
        */
    }
}
