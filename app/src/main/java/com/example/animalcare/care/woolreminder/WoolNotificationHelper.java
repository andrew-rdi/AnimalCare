package com.example.animalcare.care.woolreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class WoolNotificationHelper extends ContextWrapper {

    public static final String channel1ID_woolreninder = "channel1ID_woolreninder";
    public static final String channel1Name_woolreninder = "Channel 1_woolreninder";

    private NotificationManager mManager_woolreninder;

    public WoolNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channewool = new NotificationChannel(channel1ID_woolreninder, channel1Name_woolreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channewool.enableLights(true);
        channewool.enableVibration(true);
        channewool.setLightColor(R.color.colorPrimary);
        channewool.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channewool);
    }

    public NotificationManager getManager() {
        if (mManager_woolreninder == null) {
            mManager_woolreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_woolreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_woolreninder)
                .setContentTitle("Нагадування: розчешіть свого вихованця")
                .setContentText(message)
                .setSmallIcon(R.drawable.wool);
    }

}