package com.twotoasters.hellostudio.notification;


/**
 * Created by patrickjackson on 3/31/14.
 */

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.twotoasters.hellostudio.R;
import com.twotoasters.hellostudio.event.FromNotificationEvent;
import com.twotoasters.hellostudio.util.BusProvider;


public class AwesomeNotificationService extends IntentService {


    public AwesomeNotificationService() {
        // The super call is required. The background thread that IntentService
        // starts is labeled with the string argument you pass.
        super("com.twotoasters.hellostudio");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //message the user typed in
        String usersMessage = intent.getStringExtra(CommonConstants.EXTRA_MESSAGE);
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        String action = intent.getAction();
        switch (action){
            case CommonConstants.ACTION_PING:
                nm.cancel(CommonConstants.NOTIFICATION_ID);
                issueNotification(usersMessage);
                break;
            case CommonConstants.ACTION_FROM_NOTIFICATION_EVENT:
                sendFromNotificationEvent();
                nm.cancel(CommonConstants.NOTIFICATION_ID);
                Log.d(CommonConstants.DEBUG_TAG, getString(R.string.event_from_notification));
                break;
            case CommonConstants.ACTION_DISMISS:
                nm.cancel(CommonConstants.NOTIFICATION_ID);
                break;
        }
    }

    private void issueNotification(String message) {
        Intent dismissIntent = new Intent(this, AwesomeNotificationService.class);
        dismissIntent.setAction(CommonConstants.ACTION_DISMISS);

        PendingIntent piDismiss = PendingIntent.getService(this, 0, dismissIntent, 0);

        Intent postIntent = new Intent(this, AwesomeNotificationService.class);
        postIntent.setAction(CommonConstants.ACTION_FROM_NOTIFICATION_EVENT);

        PendingIntent piPost = PendingIntent.getService(this, 0, postIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Launched with EventBus")
                .setSubText(message)
                .setSmallIcon(R.drawable.ic_launcher)
                .addAction(R.drawable.ic_stat_dismiss, "Dismiss", piDismiss)
                .addAction(
                        R.drawable.ic_action_share,
                        "Post Event",
                        piPost);

        Notification notification = new NotificationCompat.BigPictureStyle(builder)
                .bigPicture(

                        BitmapFactory.decodeResource(getResources(),
                                R.drawable.twitterlogo)
                ).build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(CommonConstants.NOTIFICATION_ID, notification);

    }


    private void sendFromNotificationEvent() {
        BusProvider.post(new FromNotificationEvent());
    }
}
