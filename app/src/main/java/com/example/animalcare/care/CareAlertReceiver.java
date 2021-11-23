package com.example.animalcare.care;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;


public class CareAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        CareNotificationHelper carenotificationHelper = new CareNotificationHelper(context);
        NotificationCompat.Builder carenb = carenotificationHelper.getChannelNotification(message);
        carenotificationHelper.getManager().notify(1, carenb.build());
    }
}