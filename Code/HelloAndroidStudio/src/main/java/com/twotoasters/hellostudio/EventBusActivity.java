package com.twotoasters.hellostudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.twotoasters.hellostudio.event.FromNotificationEvent;
import com.twotoasters.hellostudio.event.ShowCroutonEvent;
import com.twotoasters.hellostudio.event.ShowNotificationEvent;
import com.twotoasters.hellostudio.notification.AwesomeNotificationService;
import com.twotoasters.hellostudio.notification.CommonConstants;
import com.twotoasters.hellostudio.util.BusProvider;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/*
 *  Demonstrates eventbus pattern using Square's Otto lib.  Trivial example here,
 *  but can be used to send events to other classes and keep
 *  objects loosely coupled
 */
public class EventBusActivity extends Activity {
    private CheckBox notificationCheckBox;
    private CheckBox croutonCheckBox;
    private Button eventButton;
    private TextView fromNotificationTextView;
    private EditText editMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eventbus);

        initViews();
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.unregister(this);
    }

    private void initViews() {
        notificationCheckBox = (CheckBox) findViewById(R.id.notificationCheckBox);
        croutonCheckBox = (CheckBox) findViewById(R.id.croutonCheckBox);
        fromNotificationTextView = (TextView) findViewById(R.id.fromNotificationTextView);
        eventButton = (Button) findViewById(R.id.crouton_button);
        editMessageText = (EditText) findViewById(R.id.editMessage);

        eventButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eventButtonClick();
            }
        });
    }

    private void eventButtonClick() {
        String message = editMessageText.getText().toString();
        if (notificationCheckBox.isChecked()) {
            BusProvider.post(new ShowNotificationEvent(message));
        }
        if (croutonCheckBox.isChecked()) {
            BusProvider.post(new ShowCroutonEvent());
        }
    }

    private void showNotification(String message) {
        startService(new Intent(getApplicationContext(), AwesomeNotificationService.class)
                .putExtra(CommonConstants.EXTRA_MESSAGE, message)
                .setAction(CommonConstants.ACTION_PING));
    }

    ////////////////////////////////////////////////////////////////
    // Begin EventBus event receivers
    ////////////////////////////////////////////////////////////////

    @Subscribe
    public void onShowToast(ShowCroutonEvent showCroutonEvent) {
        Crouton.makeText(EventBusActivity.this, "Crouton from Eventbus", Style.INFO).show();
    }

    @Subscribe
    public void onShowNotification(ShowNotificationEvent showNotificationEvent) {
        showNotification(showNotificationEvent.getMessage());
    }

    @Subscribe
    public void onFromNotication(FromNotificationEvent fromNotificationEvent) {
        fromNotificationTextView.setText(getText(R.string.activity_eventbus_event_text));
    }

}
