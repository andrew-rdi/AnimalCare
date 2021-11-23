package com.example.animalcare.care.woolreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.vitaminsreminder.VitaminsNotificationHelper;

public class WoolAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        WoolNotificationHelper woolnotificationHelper = new WoolNotificationHelper(context);
        NotificationCompat.Builder woolhnb = woolnotificationHelper.getChannelNotification(message);
        woolnotificationHelper.getManager().notify(1, woolhnb.build());
    }
}