package com.example.animalcare.care;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class CareNotificationHelper extends ContextWrapper {

    public static final String channel1ID_carereninder = "channel1ID_carereninder";
    public static final String channel1Name_carereninder = "Channel 1_carereninder";

    private NotificationManager mManager_carereninder;

    public CareNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channelcare = new NotificationChannel(channel1ID_carereninder, channel1Name_carereninder, NotificationManager.IMPORTANCE_DEFAULT);
        channelcare.enableLights(true);
        channelcare.enableVibration(true);
        channelcare.setLightColor(R.color.colorPrimary);
        channelcare.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channelcare);
    }

    public NotificationManager getManager() {
        if (mManager_carereninder == null) {
            mManager_carereninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_carereninder;
    }

    public NotificationCompat.Builder getChannelNotification( String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_carereninder)
                .setContentTitle("Нагадування про водні процедури")
                .setContentText(message)
                .setSmallIcon(R.drawable.water);
    }

}
