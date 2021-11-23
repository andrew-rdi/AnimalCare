package com.example.animalcare.care.earreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.clawsreminder.ClawsNotificationHelper;

public class EarAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        EarNotificationHelper earnotificationHelper = new EarNotificationHelper(context);
        NotificationCompat.Builder carenb = earnotificationHelper.getChannelNotification(message);
        earnotificationHelper.getManager().notify(1, carenb.build());
    }
}