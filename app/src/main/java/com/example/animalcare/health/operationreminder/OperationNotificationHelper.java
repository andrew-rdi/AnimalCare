package com.example.animalcare.health.operationreminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class OperationNotificationHelper extends ContextWrapper {

    public static final String channel1ID_operationreninder = "channel1ID_operationreninder";
    public static final String channel1Name_operationreninder = "Channel 1_operationreninder";

    private NotificationManager mManager_operationreninder;

    public OperationNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channeoperation = new NotificationChannel(channel1ID_operationreninder, channel1Name_operationreninder, NotificationManager.IMPORTANCE_DEFAULT);
        channeoperation.enableLights(true);
        channeoperation.enableVibration(true);
        channeoperation.setLightColor(R.color.colorPrimary);
        channeoperation.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channeoperation);
    }

    public NotificationManager getManager() {
        if (mManager_operationreninder == null) {
            mManager_operationreninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_operationreninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_operationreninder)
                .setContentTitle("Нагадування про операції")
                .setContentText(message)
                .setSmallIcon(R.drawable.operation);
    }

}