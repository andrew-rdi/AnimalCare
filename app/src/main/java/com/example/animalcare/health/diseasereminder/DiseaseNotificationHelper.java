package com.example.animalcare.health.diseasereminder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.animalcare.R;

public class DiseaseNotificationHelper extends ContextWrapper {

    public static final String channel1ID_diseasereninder = "channel1ID_diseasereninder";
    public static final String channel1Name_diseasereninder = "Channel 1_diseasereninder";

    private NotificationManager mManager_diseasereninder;

    public DiseaseNotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelsCare();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannelsCare() {
        NotificationChannel channedisease = new NotificationChannel(channel1ID_diseasereninder, channel1Name_diseasereninder, NotificationManager.IMPORTANCE_DEFAULT);
        channedisease.enableLights(true);
        channedisease.enableVibration(true);
        channedisease.setLightColor(R.color.colorPrimary);
        channedisease.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channedisease);
    }

    public NotificationManager getManager() {
        if (mManager_diseasereninder == null) {
            mManager_diseasereninder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager_diseasereninder;
    }

    public NotificationCompat.Builder getChannelNotification(String message) {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID_diseasereninder)
                .setContentTitle("Нагадування про запис хвороби")
                .setContentText(message)
                .setSmallIcon(R.drawable.history);
    }

}