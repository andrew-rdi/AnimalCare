package com.example.animalcare.documents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.animalcare.BeginActivity;
import com.example.animalcare.MainActivity;
import com.example.animalcare.R;
import com.example.animalcare.documents.tablayout.Table;

public class Documents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        //развернуть игру на весь экран - начло
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран - конец


        //docuum
        Button docuum = findViewById(R.id.docuum);
        docuum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Documents.this, PdfInput.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });


        //documopen
        Button documopen = findViewById(R.id.documopen);
        documopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Documents.this, Table.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });
    }

}
