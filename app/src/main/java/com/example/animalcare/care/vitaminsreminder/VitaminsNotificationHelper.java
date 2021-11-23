package com.example.animalcare.care.vitaminsreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class VitaminsNotificationHelper extends ContextWrapper {

    public static final String channel1ID_vitaminsreninder = "channel1ID_vitaminsreninder";
    public static final String channel1Name_vitaminsreninder = "Channel 1_vitaminsreninder";

    private NotificationManager mManager_vitaminsreninder;

    public VitaminsNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channevitamins = new NotificationChannel(channel1ID_vitaminsreninder, channel1Name_vitaminsreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channevitamins.enableLights(true);
        channevitamins.enableVibration(true);
        channevitamins.setLightColor(R.color.colorPrimary);
        channevitamins.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channevitamins);
    }

    public NotificationManager getManager() {
        if (mManager_vitaminsreninder == null) {
            mManager_vitaminsreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_vitaminsreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_vitaminsreninder)
                .setContentTitle("Нагадування про прийом вітамінів")
                .setContentText(message)
                .setSmallIcon(R.drawable.vitamin);
    }

}