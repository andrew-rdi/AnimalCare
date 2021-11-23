package com.example.animalcare.care.teethreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.gamereminder.GameNotificationHelper;

public class TeethAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        TeethNotificationHelper teethnotificationHelper = new TeethNotificationHelper(context);
        NotificationCompat.Builder teethnb = teethnotificationHelper.getChannelNotification(message);
        teethnotificationHelper.getManager().notify(1, teethnb.build());
    }
}