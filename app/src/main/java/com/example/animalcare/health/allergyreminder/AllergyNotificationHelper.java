package com.example.animalcare.health.allergyreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class AllergyNotificationHelper extends ContextWrapper {

    public static final String channel1ID_allergyreninder = "channel1ID_allergyreninder";
    public static final String channel1Name_allergyreninder= "Channel 1_allergyreninder";

    private NotificationManager mManager_allergyreninder;

    public AllergyNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeallergy = new NotificationChannel(channel1ID_allergyreninder, channel1Name_allergyreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeallergy.enableLights(true);
        channeallergy.enableVibration(true);
        channeallergy.setLightColor(R.color.colorPrimary);
        channeallergy.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeallergy);
    }

    public NotificationManager getManager() {
        if (mManager_allergyreninder == null) {
            mManager_allergyreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_allergyreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_allergyreninder)
                .setContentTitle("Нагадування про прийняття засобів від алергії")
                .setContentText(message)
                .setSmallIcon(R.drawable.wool);
    }

}