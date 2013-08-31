package com.twotoasters.hellostudio;

import android.app.Activity;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

import com.twotoasters.hellostudio.MavenLibraryActivity;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class MavenLibraryActivityTest {

    MavenLibraryActivity activity;

    @Before public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MavenLibraryActivity.class).get();
    }

    @Test public void testImageView() {
        ImageView view = new ImageView(Robolectric.application);

        int width = MeasureSpec.makeMeasureSpec(150, MeasureSpec.EXACTLY);
        int height = MeasureSpec.makeMeasureSpec(150, MeasureSpec.EXACTLY);

        view.measure(width, height);

        assertThat(view).hasMeasuredWidth(150);
        assertThat(view).hasMeasuredHeight(150);
    }

    @Test public void testGetImageUrl() {
        Assertions.assertThat(activity.getImageUrl()).isEqualTo("http://www.gravatar.com/avatar/aaa0d355f3b4971c57396d5d51861f44?size=250");
    }
}
