package com.twotoasters.hellostudio.event;

/**
 * Created by patrickjackson on 3/31/14.
 */
public class ShowNotificationEvent {
    String message;

    public ShowNotificationEvent(String message) {
       this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

