package com.example.animalcare.health.veterinarianreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.health.operationreminder.OperationNotificationHelper;

public class VeterinarianAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        VeterinarianNotificationHelper veterinariannotificationHelper = new VeterinarianNotificationHelper(context);
        NotificationCompat.Builder veterinarianhnb = veterinariannotificationHelper.getChannelNotification(message);
        veterinariannotificationHelper.getManager().notify(1, veterinarianhnb.build());
    }
}