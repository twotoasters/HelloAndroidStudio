package com.twotoasters.hellostudio;

import android.app.Activity;
import android.widget.TextView;

import com.twotoasters.hellostudio.event.FromNotificationEvent;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.hamcrest.core.Is.is;

@RunWith(RobolectricGradleTestRunner.class)
public class EventBusActivityTest {

    @Test
    public void shouldHaveEmptyTextView() throws Exception {
        Activity eventBusActivity = Robolectric.buildActivity(EventBusActivity.class).create().get();
        TextView fromNotificationTextView = (TextView) eventBusActivity.findViewById(R.id.fromNotificationTextView);
        Assert.assertThat(fromNotificationTextView.getText().toString(), is(""));
    }


    @Test
    public void shouldChangeTextInActivity() throws Exception {
        Activity eventBusActivity = Robolectric.buildActivity(EventBusActivity.class).create().visible().get();

        //In real app event sent from AwesomeNotificationService after tapping Post Event
        ((EventBusActivity) eventBusActivity).onFromNotication(new FromNotificationEvent());
        TextView fromNotificationTextView = (TextView) eventBusActivity.findViewById(R.id.fromNotificationTextView);

        Assert.assertThat(fromNotificationTextView.getText().toString(),
                is(eventBusActivity.getString(R.string.activity_eventbus_event_text)));
    }
}

