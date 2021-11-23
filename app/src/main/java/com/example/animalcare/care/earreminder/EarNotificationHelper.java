package com.example.animalcare.care.earreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class EarNotificationHelper extends ContextWrapper {

    public static final String channel1ID_earsreninder = "channel1ID_earsreninder";
    public static final String channel1Name_earsreninder = "Channel 1_cearsreninder";

    private NotificationManager mManager_earsreninder;

    public EarNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeear = new NotificationChannel(channel1ID_earsreninder, channel1Name_earsreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeear.enableLights(true);
        channeear.enableVibration(true);
        channeear.setLightColor(R.color.colorPrimary);
        channeear.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeear);
    }

    public NotificationManager getManager() {
        if (mManager_earsreninder == null) {
            mManager_earsreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_earsreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_earsreninder)
                .setContentTitle("Нагадування про чистку вух тварини")
                .setContentText(message)
                .setSmallIcon(R.drawable.earpng);
    }

}