package com.twotoasters.hellostudio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

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
