package com.twotoasters.hellostudio;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

import static android.test.ViewAsserts.assertOnScreen;

import static org.fest.assertions.api.Assertions.assertThat;

import com.twotoasters.hellostudio.MavenLibraryActivity;

public class MavenActivityInstrumentTest extends ActivityInstrumentationTestCase2<MavenLibraryActivity> {

    private MavenLibraryActivity activity;
    private TextView textView;
    private ImageView imageView;

    // Be careful about letting the IDE create the constructor.  As of this writing,
    // it creates a constructor that's compiles cleanly but doesn't run any tests
    public MavenActivityInstrumentTest() {
        super(MavenLibraryActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        activity = getActivity();
        textView = (TextView) activity.findViewById(R.id.textView);
        imageView = (ImageView) activity.findViewById(R.id.imageView);
    }

    // Methods whose names are prefixed with test will automatically be run
    public void testTextView() {
        assertThat(textView).isNotNull();
        assertOnScreen(activity.getWindow().getDecorView(), textView);
    }

    public void testImageUrl() {
        assertThat(activity.getImageUrl()).isEqualTo("http://www.gravatar.com/avatar/aaa0d355f3b4971c57396d5d51861f44?size=250");
    }

    public void testImageView() {
        assertThat(imageView).isNotNull();
        assertOnScreen(activity.getWindow().getDecorView(), imageView);
    }
}