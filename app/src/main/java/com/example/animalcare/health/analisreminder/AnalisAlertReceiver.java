package com.example.animalcare.health.analisreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.health.allergyreminder.AllergyNotificationHelper;

public class AnalisAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        AnalisNotificationHelper analisnotificationHelper = new AnalisNotificationHelper(context);
        NotificationCompat.Builder analishnb = analisnotificationHelper.getChannelNotification(message);
        analisnotificationHelper.getManager().notify(1, analishnb.build());
    }
}