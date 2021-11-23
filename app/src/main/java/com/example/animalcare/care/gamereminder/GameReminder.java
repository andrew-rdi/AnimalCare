package com.example.animalcare.care.gamereminder;

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
import com.example.animalcare.care.clawsreminder.ClawsReminder;
import com.example.animalcare.care.eatreminder.EatAlertReceiver;
import com.example.animalcare.care.eatreminder.EatTimePickerFragment;
import com.example.animalcare.notes.Notes;

import java.text.DateFormat;
import java.util.Calendar;

public class GameReminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TextView mTextView_gamereminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_reminder);

        mTextView_gamereminder = findViewById(R.id.textView_gamereminder);

        Button button_TimePicker_gamereminder = findViewById(R.id.button_timepicker_gamereminder);
        button_TimePicker_gamereminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment game_timePicker = new GameTimePickerFragment();
                game_timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button button_cancel_gamereminder = findViewById(R.id.button_cancel_gamereminder);
        button_cancel_gamereminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        //button_care_back
        Button button_game_back = findViewById(R.id.button_game_back);
        button_game_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(GameReminder.this, CareList.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_carechoose_5
        Button button_gamereminder_notes = findViewById(R.id.button_gamereminder_notes);
        button_gamereminder_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(GameReminder.this, Notes.class);
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

        mTextView_gamereminder.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, GameAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }

    private void cancelAlarm() {
        AlarmManager alarmManager_eatreminder = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, GameAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager_eatreminder.cancel(pendingIntent);
        mTextView_gamereminder.setText("Немає нагадувань");
    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(GameReminder.this, CareList.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}