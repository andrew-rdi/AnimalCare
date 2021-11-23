package com.example.animalcare.care.eatreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.earreminder.EarNotificationHelper;

public class EatAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        EatNotificationHelper eatnotificationHelper = new EatNotificationHelper(context);
        NotificationCompat.Builder eatnb = eatnotificationHelper.getChannelNotification(message);
        eatnotificationHelper.getManager().notify(1, eatnb.build());
    }
}