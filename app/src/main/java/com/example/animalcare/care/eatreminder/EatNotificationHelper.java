package com.example.animalcare.care.eatreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class EatNotificationHelper extends ContextWrapper {

    public static final String channel1ID_eatreninder = "channel1ID_eatreninder";
    public static final String channel1Name_eatsreninder = "Channel 1_eatsreninder";

    private NotificationManager mManager_eatreninder;

    public EatNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeeat = new NotificationChannel(channel1ID_eatreninder, channel1Name_eatsreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeeat.enableLights(true);
        channeeat.enableVibration(true);
        channeeat.setLightColor(R.color.colorPrimary);
        channeeat.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeeat);
    }

    public NotificationManager getManager() {
        if (mManager_eatreninder == null) {
            mManager_eatreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_eatreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_eatreninder)
                .setContentTitle("Нагадування про прийом їжі")
                .setContentText(message)
                .setSmallIcon(R.drawable.eat);
    }

}