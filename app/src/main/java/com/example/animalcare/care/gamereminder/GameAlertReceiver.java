package com.example.animalcare.care.gamereminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.animalcare.care.eatreminder.EatNotificationHelper;

public class GameAlertReceiver extends BroadcastReceiver {

    private  String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        GameNotificationHelper gamenotificationHelper = new GameNotificationHelper(context);
        NotificationCompat.Builder gamenb = gamenotificationHelper.getChannelNotification(message);
        gamenotificationHelper.getManager().notify(1, gamenb.build());
    }
}