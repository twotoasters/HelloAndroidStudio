package com.twotoasters.hellostudio;

import android.app.Activity;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void testImageView() {
        ImageView view = new ImageView(Robolectric.application);

        int width = MeasureSpec.makeMeasureSpec(100, MeasureSpec.EXACTLY);
        int height = MeasureSpec.makeMeasureSpec(200, MeasureSpec.EXACTLY);

        view.measure(width, height);

        assertThat(view).hasMeasuredWidth(100);
        assertThat(view).hasMeasuredHeight(200);
    }

    /*
     * This test is currently broken due to gradle android test plugin issue #7
     */
    @Test public void testGetImageUrl() {
        /*
        MainActivity activity = new MainActivity();
        assertThat(activity).isNotNull();
        activity.onCreate(null);
        assertThat(activity.getImageUrl()).isEqualTo("http://www.gravatar.com/avatar/aaa0d355f3b4971c57396d5d51861f44?size=250");
        */
    }
}
