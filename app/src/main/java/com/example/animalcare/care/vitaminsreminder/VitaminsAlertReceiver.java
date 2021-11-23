package com.example.animalcare.care.vitaminsreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.teethreminder.TeethNotificationHelper;

public class VitaminsAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        VitaminsNotificationHelper vitaminsnotificationHelper = new VitaminsNotificationHelper(context);
        NotificationCompat.Builder vitaminshnb = vitaminsnotificationHelper.getChannelNotification(message);
        vitaminsnotificationHelper.getManager().notify(1, vitaminshnb.build());
    }
}