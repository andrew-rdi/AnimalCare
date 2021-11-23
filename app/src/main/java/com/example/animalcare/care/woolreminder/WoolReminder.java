package com.example.animalcare.care.woolreminder;

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
import com.example.animalcare.care.CareList;
import com.example.animalcare.care.clawsreminder.ClawsReminder;
import com.example.animalcare.care.vitaminsreminder.VitaminsAlertReceiver;
import com.example.animalcare.care.vitaminsreminder.VitaminsTimePickerFragment;
import com.example.animalcare.notes.Notes;

import java.text.DateFormat;
import java.util.Calendar;

public class WoolReminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TextView mTextView_woolreminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wool_reminder);

        mTextView_woolreminder = findViewById(R.id.textView_woolreminder);

        Button button_TimePicker_woolreminder = findViewById(R.id.button_timepicker_woolreminder);
        button_TimePicker_woolreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment wool_timePicker = new WoolTimePickerFragment();
                wool_timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button button_cancel_woolreminder = findViewById(R.id.button_cancel_woolreminder);
        button_cancel_woolreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        //button_care_back
        Button button_wool_back = findViewById(R.id.button_wool_back);
        button_wool_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(WoolReminder.this, CareList.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_carechoose_5
        Button button_woolreminder_notes = findViewById(R.id.button_woolreminder_notes);
        button_woolreminder_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(WoolReminder.this, Notes.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
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
        String timeText = "Нагадування встановлено на: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView_woolreminder.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, WoolAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }

    private void cancelAlarm() {
        AlarmManager alarmManager_woolreminder = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, WoolAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager_woolreminder.cancel(pendingIntent);
        mTextView_woolreminder.setText("Немає нагадувань");
    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(WoolReminder.this, CareList.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}