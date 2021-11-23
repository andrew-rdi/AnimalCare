package com.example.animalcare.health.analisreminder;

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

import com.example.animalcare.R;
import com.example.animalcare.care.CareList;
import com.example.animalcare.health.HealthList;
import com.example.animalcare.health.allergyreminder.AllergyAlertReceiver;
import com.example.animalcare.health.allergyreminder.AllergyReminder;
import com.example.animalcare.health.allergyreminder.AllergyTimePickerFragment;
import com.example.animalcare.notes.Notes;

import java.text.DateFormat;
import java.util.Calendar;

public class AnalisReminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TextView mTextView_analisreminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analis_reminder);

        mTextView_analisreminder = findViewById(R.id.textView_analisreminder);

        Button button_TimePicker_analisreminder = findViewById(R.id.button_timepicker_analisreminder);
        button_TimePicker_analisreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment analis_timePicker = new AnalisTimePickerFragment();
                analis_timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button button_cancel_analisreminder = findViewById(R.id.button_cancel_analisreminder);
        button_cancel_analisreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        //button_care_back
        Button button_analis_back = findViewById(R.id.button_analis_back);
        button_analis_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(AnalisReminder.this, HealthList.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_carechoose_5
        Button button_analisreminder_notes = findViewById(R.id.button_analisreminder_notes);
        button_analisreminder_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(AnalisReminder.this, Notes.class);
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

        mTextView_analisreminder.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AnalisAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }

    private void cancelAlarm() {
        AlarmManager alarmManager_analisreminder = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AnalisAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager_analisreminder.cancel(pendingIntent);
        mTextView_analisreminder.setText("Немає нагадувань");
    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(AnalisReminder.this, HealthList.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}