package com.example.animalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.animalcare.care.CareList;
import com.example.animalcare.documents.tablayout.Table;
import com.example.animalcare.form.MyPet;
import com.example.animalcare.gameforpet.GameForPet;
import com.example.animalcare.gameforyou.Gameforyou;
import com.example.animalcare.health.HealthList;
import com.example.animalcare.images.Images;
import com.example.animalcare.notes.Notes;
import com.example.animalcare.shelter.Shelter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BeginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    ImageView bgapp, clover, exitIm;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);


        firebaseAuth = FirebaseAuth.getInstance();


        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        bgapp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textsplash = findViewById(R.id.textsplash);
        texthome = findViewById(R.id.texthome);
        exitIm = findViewById(R.id.exitIm);

        menus = findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


//        Button button_back = findViewById(R.id.button_back);
//        button_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent = new Intent(BeginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                } catch (Exception e) {
//
//                }
//            }
//        });


        //кнопка для перехода на анкету - начало
        ImageView exitIm = findViewById(R.id.exitIm);
        exitIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firebaseAuth.signOut();
                    checkUserStatus();
                }catch (Exception e) {

                }
            }
        });


        //кнопка для перехода на анкету - начало
        ImageView pet_image = findViewById(R.id.pet_image);
        pet_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, MyPet.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на анкету - конец

        //кнопка для перехода на документы - начало
        ImageView doc_image = (ImageView)findViewById(R.id.doc_image);
        doc_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, Table.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на документы - конец

        //кнопка для перехода на заметки - начало
        ImageView notes_image = (ImageView)findViewById(R.id.notes_image);
        notes_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, Notes.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на заметки - конец

        //кнопка для перехода на галерею - начало
        ImageView gallery_images  = (ImageView)findViewById(R.id.gallery_image);
        gallery_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, Images.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на галерею - конец

        //кнопка для перехода на уход - начало
        ImageView care_images  = (ImageView)findViewById(R.id.care_image);
        care_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, CareList.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на уход - конец

        //кнопка для перехода на здоровье - начало
        ImageView health_images  = (ImageView)findViewById(R.id.health_image);
        health_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, HealthList.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на здоровье - конец

        //кнопка для перехода на игры для питомца - начало
        ImageView game_images  = (ImageView)findViewById(R.id.game_image);
        game_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, GameForPet.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на игры для питомца - конец

        //кнопка для перехода на игру для пользователя - начало
        ImageView gamepep_image = (ImageView)findViewById(R.id.gamepep_image);
        gamepep_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, Gameforyou.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на игру для пользователя  - конец

        //кнопка для перехода на приюты - начало
        ImageView shelter_image = (ImageView)findViewById(R.id.shelter_image);
        shelter_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(BeginActivity.this, Shelter.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка для перехода на приюты - конец

    }

    /*
    //Системная кнопка назад - старт
    @Override
    public void onBackPressed() {
        //начало конструкции
        try {
            Intent intent = new Intent(BeginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
        //конец конструкции
    }
    //Системная кнопка назад - конец

    */


    private void  checkUserStatus() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            //mProfileTv.setText(user.getEmail());
        }
        else {
            startActivity(new Intent(BeginActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        checkUserStatus();
        super.onStart();
    }

}
