package com.example.animalcare.health.operationreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.health.analisreminder.AnalisNotificationHelper;

public class OperationAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        OperationNotificationHelper operationnotificationHelper = new OperationNotificationHelper(context);
        NotificationCompat.Builder operationhnb = operationnotificationHelper.getChannelNotification(message);
        operationnotificationHelper.getManager().notify(1, operationhnb.build());
    }
}