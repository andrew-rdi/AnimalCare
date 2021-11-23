package com.example.animalcare.gameforyou;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animalcare.BeginActivity;
import com.example.animalcare.R;

public class Gameforyou extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    public int count = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameforyou);

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);

        final ImageView left_image = (ImageView)findViewById(R.id.left_image);
        //скругление углов
        left_image.setClipToOutline(true);
        // скругление углов

        final ImageView right_image = (ImageView)findViewById(R.id.rigth_image);
        //скругление углов
        right_image.setClipToOutline(true);
        // скругление углов

        //Окно на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Окно на весь экран

        //вызов диалогового окна
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        //кнопка, которая закрывает диалоговое окно начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btn_close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Gameforyou.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
                dialog.dismiss();
            }
        });
        //кнопка, которая закрывает диалоговое окно конец

        //кнопка продолжить - наччало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //кнопка продолжить - конец

        dialog.show();
        //вызов диалогового окна

        //______________________________
        //вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        //кнопка, которая закрывает диалоговое окно начало
        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btn_close);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Gameforyou.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
                dialogEnd.dismiss();
            }
        });
        //кнопка, которая закрывает диалоговое окно конец

        //кнопка продолжить - наччало
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                 Intent intent =  new Intent(Gameforyou.this, BeginActivity.class);
                 startActivity(intent);
                 finish();
                }catch (Exception e) {

                }
                dialogEnd.dismiss();
            }
        });
        //кнопка продолжить - конец

        //вызов диалогового окна в конце игры
        //______________________________

        //кнопка назад - начало
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Gameforyou.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //кнопка назад - конец

        //массив для прогресса игры - начало
        final int[] progress = {
                R.id.point_1, R.id.point_2, R.id.point_3, R.id.point_4, R.id.point_2,
        };
        //массив для прогресса игры - конец

        //подключение анимации
        final Animation a = AnimationUtils.loadAnimation(Gameforyou.this, R.anim.alpha);
        //подключение анимации

        numLeft = 0;
        left_image.setImageResource(array.images1[numLeft]);

        numRight = 1;
        right_image.setImageResource(array.images1[numRight]);

        //нажатие на левую картинку - начало
        left_image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    right_image.setEnabled(false);
                    if(numLeft<numRight){
                        left_image.setImageResource(R.drawable.img_true);
                    }else {
                        left_image.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (numLeft<numRight){
                        if (count < 5) {
                            count = count + 1;
                        }

                        //filling progress
                        for (int i = 0; i < 5; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //filling progress

                        //определяем правильные ответы и закрашиваем в зеленый - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зеленый - конец

                    } else {
                        if (count > 0){
                            if (count == 1){
                                count = 0;
                            }else  {
                                count = count - 2;
                            }
                        }
                        //закрашивание прогресса - начало
                        for (int i = 0; i < 4; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашивание прогресса - конец

                        //определяем правильные ответы и закрашиваем в зеленый - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зеленый - конец
                    }


                        if (count == 1) {
                            numLeft = 2;
                            left_image.setImageResource(array.images1[numLeft]);
                            left_image.startAnimation(a);

                            numRight = 3;
                            right_image.setImageResource(array.images1[numRight]);
                            right_image.startAnimation(a);

                            right_image.setEnabled(true);
                        } else if (count == 2) {
                            numLeft = 4;
                            left_image.setImageResource(array.images1[numLeft]);
                            left_image.startAnimation(a);

                            numRight = 5;
                            right_image.setImageResource(array.images1[numRight]);
                            right_image.startAnimation(a);
                            right_image.setEnabled(true);
                        } else if (count == 3) {
                            numLeft = 6;
                            left_image.setImageResource(array.images1[numLeft]);
                            left_image.startAnimation(a);

                            numRight = 7;
                            right_image.setImageResource(array.images1[numRight]);
                            right_image.startAnimation(a);
                            right_image.setEnabled(true);
                        } else if (count == 4) {
                            numLeft = 8;
                            left_image.setImageResource(array.images1[numLeft]);
                            left_image.startAnimation(a);

                            numRight = 9;
                            right_image.setImageResource(array.images1[numRight]);
                            right_image.startAnimation(a);
                            right_image.setEnabled(true);
                        } else if (count == 5) {
                            //ВЫХОД ИЗ ИГРЫ
                            dialogEnd.show();
                        }



                }

                return true;
            }
        });
        //нажатие на левую картинку - конец


        //нажатие на правую картинку - начало
        right_image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    right_image.setEnabled(false);
                    if(numLeft>numRight){
                       right_image.setImageResource(R.drawable.img_true);
                    }else {
                        right_image.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (numLeft>numRight){
                        if (count < 5) {
                            count = count + 1;
                        }

                        //закрашивание прогресса - начало
                        for (int i = 0; i < 5; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашивание прогресса - конец

                        //определяем правильные ответы и закрашиваем в зеленый - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зеленый - конец
                    }else {
                        if (count > 0){
                            if (count==1){
                                count = 0;
                            }else  {
                                count = count - 2;
                            }
                        }
                        //закрашивание прогресса - начало
                        for (int i = 0; i < 4; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашивание прогресса - конец

                        //определяем правильные ответы и закрашиваем в зеленый - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем в зеленый - конец
                    }


                    if (count == 1) {
                        numLeft = 2;
                        left_image.setImageResource(array.images1[numLeft]);
                        left_image.startAnimation(a);

                        numRight = 3;
                        right_image.setImageResource(array.images1[numRight]);
                        right_image.startAnimation(a);

                       left_image.setEnabled(true);
                    } else if (count == 2) {
                        numLeft = 4;
                        left_image.setImageResource(array.images1[numLeft]);
                        left_image.startAnimation(a);

                        numRight = 5;
                        right_image.setImageResource(array.images1[numRight]);
                        right_image.startAnimation(a);

                        left_image.setEnabled(true);
                    } else if (count == 3) {
                        numLeft = 6;
                        left_image.setImageResource(array.images1[numLeft]);
                        left_image.startAnimation(a);

                        numRight = 7;
                        right_image.setImageResource(array.images1[numRight]);
                        right_image.startAnimation(a);
                        left_image.setEnabled(true);
                    } else if (count == 4) {
                        numLeft = 8;
                        left_image.setImageResource(array.images1[numLeft]);
                        left_image.startAnimation(a);

                        numRight = 9;
                        right_image.setImageResource(array.images1[numRight]);
                        right_image.startAnimation(a);
                        left_image.setEnabled(true);
                    } else if (count == 5){
                        dialogEnd.show();
                    }


                }

                return true;
            }
        });
        //нажатие на правую картинку - конец


    }
    //системная кнопка - начало
        @Override
    public void onBackPressed(){
            try{
                Intent intent = new Intent(Gameforyou.this, BeginActivity.class);
                startActivity(intent);
                finish();
            }catch (Exception e) {

            }
        }
    //системная кнопка - конец
}
