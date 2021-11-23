package com.example.animalcare.gameforpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.animalcare.BeginActivity;
import com.example.animalcare.R;
import com.example.animalcare.gameforpet.traninglist.Training;
import com.example.animalcare.gameforyou.Gameforyou;

public class GameForPet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_for_pet);

        //развернуть игру на весь экран - начло
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран - конец


        Button button_petwalk_back = (Button)findViewById(R.id.button_petwalk_back);
        button_petwalk_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(GameForPet.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_training
        Button button_training = (Button)findViewById(R.id.button_training);
        button_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(GameForPet.this, Training.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_petwalk_start
        Button button_petwalk_starttrin = findViewById(R.id.button_petwalk_starttrin);
        button_petwalk_starttrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameForPet.this, StopWatchAct.class);
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
            Intent intent = new Intent(GameForPet.this, BeginActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}
