package com.example.animalcare.shelter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.animalcare.BeginActivity;
import com.example.animalcare.R;
import com.example.animalcare.hotel.Hotels;

public class Shelter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);

        //развернуть игру на весь экран - начло
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран - конец

        //button_shelter_back
        Button button_shelter_back = findViewById(R.id.button_shelter_back);
        button_shelter_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Shelter.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //button_shelter_1
        Button button_shelter_1 = findViewById(R.id.button_shelter_1);
        button_shelter_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Shelter.this, SheltersForPet.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });
        //button_hotel
        Button button_hotel = findViewById(R.id.button_hotel);
        button_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Shelter.this, Hotels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Shelter.this, BeginActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}
