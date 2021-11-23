package com.example.animalcare.gameforpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.example.animalcare.R;
import com.example.animalcare.gameforpet.traninglist.Training;
import com.example.animalcare.gameforpet.traninglist.TrainingCat;

public class StopWatchAct extends AppCompatActivity {
    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icacnhor);
        timerHere = findViewById(R.id.timerHere);

        btnstop.setAlpha(0);

        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                icanchor.animate().alpha(1);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.animate().alpha(0); //stop
                btnstop.animate().alpha(0).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(1).setDuration(300).start();
                timerHere.stop();
            }
        });

        //button_back_watch
        Button button_back_watch = findViewById(R.id.button_back_watch);
        button_back_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(StopWatchAct.this, GameForPet.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {

                }

            }
        });

    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(StopWatchAct.this, GameForPet.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}