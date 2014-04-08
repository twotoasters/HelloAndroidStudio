package com.twotoasters.hellostudio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    MainActivity activity;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        activity = new MainActivity();
//        activity.onCreate(null);
    }

    @Test public void testNotNull() {
        assertThat(activity).isNotNull();
    }
}
