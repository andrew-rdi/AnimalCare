package com.example.animalcare.care.gamereminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class GameNotificationHelper extends ContextWrapper {

    public static final String channel1ID_gamereninder = "channel1ID_gamereninder";
    public static final String channel1Name_gamereninder = "Channel 1_gamereninder";

    private NotificationManager mManager_gamereninder;

    public GameNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channegame = new NotificationChannel(channel1ID_gamereninder, channel1Name_gamereninder, NotificationManager.IMPORTANCE_DEFAULT);
        channegame.enableLights(true);
        channegame.enableVibration(true);
        channegame.setLightColor(R.color.colorPrimary);
        channegame.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channegame);
    }

    public NotificationManager getManager() {
        if (mManager_gamereninder == null) {
            mManager_gamereninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_gamereninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_gamereninder)
                .setContentTitle("Нагадування про прогулянку та ігри")
                .setContentText(message)
                .setSmallIcon(R.drawable.ball);
    }

}