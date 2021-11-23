package com.example.animalcare.health.allergyreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.woolreminder.WoolNotificationHelper;

public class AllergyAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        AllergyNotificationHelper allergynotificationHelper = new AllergyNotificationHelper(context);
        NotificationCompat.Builder allergyhnb = allergynotificationHelper.getChannelNotification(message);
        allergynotificationHelper.getManager().notify(1, allergyhnb.build());
    }
}