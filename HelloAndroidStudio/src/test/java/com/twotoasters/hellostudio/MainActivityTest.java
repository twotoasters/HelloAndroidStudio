package com.twotoasters.hellostudio;

import android.app.Activity;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

import com.twotoasters.hellostudio.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    MainActivity activity;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        activity = new MainActivity();
        activity.onCreate(null);
    }

    @Test public void testNotNull() {
        assertThat(activity).isNotNull();
    }
}
