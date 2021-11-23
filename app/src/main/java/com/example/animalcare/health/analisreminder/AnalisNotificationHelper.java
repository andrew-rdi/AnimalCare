package com.example.animalcare.health.analisreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class AnalisNotificationHelper extends ContextWrapper {

    public static final String channel1ID_analisreninder = "channel1ID_analisreninder";
    public static final String channel1Name_analisreninder = "Channel 1_analisreninder";

    private NotificationManager mManager_analisreninder;

    public AnalisNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeanalis = new NotificationChannel(channel1ID_analisreninder, channel1Name_analisreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeanalis.enableLights(true);
        channeanalis.enableVibration(true);
        channeanalis.setLightColor(R.color.colorPrimary);
        channeanalis.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeanalis);
    }

    public NotificationManager getManager() {
        if (mManager_analisreninder == null) {
            mManager_analisreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_analisreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_analisreninder)
                .setContentTitle("Нагадування про аналізи")
                .setContentText(message)
                .setSmallIcon(R.drawable.analispng);
    }

}