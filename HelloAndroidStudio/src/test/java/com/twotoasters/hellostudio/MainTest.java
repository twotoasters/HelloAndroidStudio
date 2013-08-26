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
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class MainTest {

    MainActivity activity;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        activity = new MainActivity();
        activity.onCreate(null);
    }

    @Test public void testImageView() {
        ImageView view = new ImageView(Robolectric.application);

        int width = MeasureSpec.makeMeasureSpec(100, MeasureSpec.EXACTLY);
        int height = MeasureSpec.makeMeasureSpec(200, MeasureSpec.EXACTLY);

        view.measure(width, height);

        assertThat(view).hasMeasuredWidth(100);
        assertThat(view).hasMeasuredHeight(200);
    }

    @Test public void testGetImageUrl() {
        assertThat(activity.getImageUrl()).isEqualTo("http://www.gravatar.com/avatar/aaa0d355f3b4971c57396d5d51861f44?size=250");
    }
}
