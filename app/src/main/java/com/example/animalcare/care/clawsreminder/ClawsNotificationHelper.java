package com.example.animalcare.care.clawsreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class ClawsNotificationHelper extends ContextWrapper {

    public static final String channel1ID_clawsreninder = "channel1ID_clawsreninder";
    public static final String channel1Name_clawsreninder = "Channel 1_clawsreninder";

    private NotificationManager mManager_clawsreninder;

    public ClawsNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeclaws = new NotificationChannel(channel1ID_clawsreninder, channel1Name_clawsreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeclaws.enableLights(true);
        channeclaws.enableVibration(true);
        channeclaws.setLightColor(R.color.colorPrimary);
        channeclaws.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeclaws);
    }

    public NotificationManager getManager() {
        if (mManager_clawsreninder == null) {
            mManager_clawsreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_clawsreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_clawsreninder)
                .setContentTitle("Нагадування про стрижку пазурів")
                .setContentText(message)
                .setSmallIcon(R.drawable.clawspng);
    }

}
