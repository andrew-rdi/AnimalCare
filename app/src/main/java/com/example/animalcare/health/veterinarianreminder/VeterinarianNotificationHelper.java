package com.example.animalcare.health.veterinarianreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class VeterinarianNotificationHelper extends ContextWrapper {

    public static final String channel1ID_veterinarianreninder = "channel1ID_veterinarianreninder";
    public static final String channel1Name_veterinarianreninder = "Channel 1_veterinarianreninder";

    private NotificationManager mManager_veterinarianreninder;

    public VeterinarianNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeveterinarian = new NotificationChannel(channel1ID_veterinarianreninder, channel1Name_veterinarianreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeveterinarian.enableLights(true);
        channeveterinarian.enableVibration(true);
        channeveterinarian.setLightColor(R.color.colorPrimary);
        channeveterinarian.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeveterinarian);
    }

    public NotificationManager getManager() {
        if (mManager_veterinarianreninder == null) {
            mManager_veterinarianreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_veterinarianreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_veterinarianreninder)
                .setContentTitle("Нагадування про відвідування ветеринара")
                .setContentText(message)
                .setSmallIcon(R.drawable.wetr);
    }

}