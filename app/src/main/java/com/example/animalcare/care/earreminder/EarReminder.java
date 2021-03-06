package com.example.animalcare.care.earreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.animalcare.BeginActivity;
import com.example.animalcare.R;
import com.example.animalcare.care.Care;
import com.example.animalcare.care.CareList;
import com.example.animalcare.care.clawsreminder.ClawsAlertReceiver;
import com.example.animalcare.care.clawsreminder.ClawsReminder;
import com.example.animalcare.care.clawsreminder.ClawsTimePickerFragment;
import com.example.animalcare.notes.Notes;

import java.text.DateFormat;
import java.util.Calendar;

public class EarReminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TextView mTextView_earreminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ear_reminder);

        mTextView_earreminder = findViewById(R.id.textView_earreminder);

        Button button_TimePicker_earreminder = findViewById(R.id.button_timepicker_earreminder);
        button_TimePicker_earreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment ear_timePicker = new EarTimePickerFragment();
                ear_timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button button_cancel_earreminder = findViewById(R.id.button_cancel_earreminder);
        button_cancel_earreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        //button_care_back
        Button button_ear_back = findViewById(R.id.button_ear_back);
        button_ear_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //???????????? ??????????????????????
                try {
                    Intent intent = new Intent(EarReminder.this, CareList.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //?????????? ??????????????????????
            }
        });

        //button_carechoose_5
        Button button_earreminder_notes = findViewById(R.id.button_earreminder_notes);
        button_earreminder_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //???????????? ??????????????????????
                try {
                    Intent intent = new Intent(EarReminder.this, Notes.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //?????????? ??????????????????????
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }

    private void updateTimeText(Calendar c) {
        String timeText = "?????????????????????? ?????????????????????? ????: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView_earreminder.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, EarAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }

    private void cancelAlarm() {
        AlarmManager alarmManager_carereminder = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, EarAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager_carereminder.cancel(pendingIntent);
        mTextView_earreminder.setText("?????????? ????????????????????");
    }
    //?????????????????? ???????????? - ????????????
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(EarReminder.this, CareList.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //?????????????????? ???????????? - ??????????
}
