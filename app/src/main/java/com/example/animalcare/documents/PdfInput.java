package com.example.animalcare.documents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.animalcare.R;
import com.example.animalcare.documents.tablayout.FragmentStore;
import com.example.animalcare.documents.tablayout.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PdfInput extends AppCompatActivity {

    private static final int STOREGE_CODE = 1000;
    EditText mTextET;
    Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_input);

        mTextET = findViewById(R.id.textEt);
        mSaveBtn = findViewById(R.id.saveBtn);


        //button_back_todopdf
        Button button_back_todopdf = findViewById(R.id.button_back_todopdf);
        button_back_todopdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(PdfInput.this, Table.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED) {

                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissions, STOREGE_CODE);
                    }
                    else {

                        savePdf();

                    }
                }
                else {
                    savePdf();
                }
            }
        });
    }

    private void savePdf() {
        Document mDoc = new Document();
        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        String mFilePath = Environment.getExternalStorageDirectory() + "/" + mFileName + ".pdf";

        try {
            PdfWriter.getInstance(mDoc, new FileOutputStream(mFilePath));
            mDoc.open();
            String mText = mTextET.getText().toString();

           // mDoc.addAuthor("Atif Pervaiz");

            mDoc.add(new Paragraph(mText));

            mDoc.close();

            Toast.makeText(this, mFileName + ".pdf\n збережено: \n" + mFilePath, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case STOREGE_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    savePdf();
                }
                else {
                    Toast.makeText(this, "В доступі відмовлено!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    //Системная кнопка назад - старт
    @Override
    public void onBackPressed() {
        //начало конструкции
        try {
            Intent intent = new Intent(PdfInput.this, Table.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
        //конец конструкции
    }
    //Системная кнопка назад - конец


}
