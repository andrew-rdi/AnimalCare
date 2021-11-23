package com.example.animalcare.care.teethreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class TeethNotificationHelper extends ContextWrapper {

    public static final String channel1ID_teethreninder = "channel1ID_teethreninder";
    public static final String channel1Name_teethreninder = "Channel 1_teethreninder";

    private NotificationManager mManager_teethreninder;

    public TeethNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeteeth = new NotificationChannel(channel1ID_teethreninder, channel1Name_teethreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeteeth.enableLights(true);
        channeteeth.enableVibration(true);
        channeteeth.setLightColor(R.color.colorPrimary);
        channeteeth.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeteeth);
    }

    public NotificationManager getManager() {
        if (mManager_teethreninder == null) {
            mManager_teethreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_teethreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_teethreninder)
                .setContentTitle("Нагадування: перевірте зуби тварини")
                .setContentText(message)
                .setSmallIcon(R.drawable.teethpng);
    }

}