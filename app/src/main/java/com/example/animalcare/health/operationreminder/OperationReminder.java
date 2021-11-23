package com.example.animalcare.health.operationreminder;

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
import com.example.animalcare.health.allergyreminder.AllergyReminder;
import com.example.animalcare.health.analisreminder.AnalisAlertReceiver;
import com.example.animalcare.health.analisreminder.AnalisTimePickerFragment;
import com.example.animalcare.notes.Notes;

import java.text.DateFormat;
import java.util.Calendar;

public class OperationReminder extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TextView mTextView_operationreminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_reminder);

        mTextView_operationreminder = findViewById(R.id.textView_operationreminder);

        Button button_TimePicker_operationreminder = findViewById(R.id.button_timepicker_operationreminder);
        button_TimePicker_operationreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment operation_timePicker = new OperationTimePickerFragment();
                operation_timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button button_cancel_operationreminder = findViewById(R.id.button_cancel_operationreminder);
        button_cancel_operationreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

        //button_care_back
        Button button_operation_back = findViewById(R.id.button_operation_back);
        button_operation_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(OperationReminder.this, HealthList.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_carechoose_5
        Button button_operationreminder_notes = findViewById(R.id.button_operationreminder_notes);
        button_operationreminder_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(OperationReminder.this, Notes.class);
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

        mTextView_operationreminder.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, OperationAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }

    private void cancelAlarm() {
        AlarmManager alarmManager_operationreminder = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, OperationAlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager_operationreminder.cancel(pendingIntent);
        mTextView_operationreminder.setText("Немає нагадувань");
    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(OperationReminder.this, HealthList.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}
