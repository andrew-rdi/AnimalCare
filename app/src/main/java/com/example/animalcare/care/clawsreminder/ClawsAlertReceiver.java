package com.example.animalcare.care.clawsreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.CareNotificationHelper;

public class ClawsAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        ClawsNotificationHelper clawsnotificationHelper = new ClawsNotificationHelper(context);
        NotificationCompat.Builder carenb = clawsnotificationHelper.getChannelNotification(message);
        clawsnotificationHelper.getManager().notify(1, carenb.build());
    }
}