package com.example.animalcare.health.diseasereminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.health.analisreminder.AnalisNotificationHelper;

public class DiseaseAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        DiseaseNotificationHelper diseasenotificationHelper = new DiseaseNotificationHelper(context);
        NotificationCompat.Builder analishnb = diseasenotificationHelper.getChannelNotification(message);
        diseasenotificationHelper.getManager().notify(1, analishnb.build());
    }
}