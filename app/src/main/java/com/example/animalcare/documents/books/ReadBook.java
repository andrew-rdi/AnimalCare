package com.example.animalcare.documents.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.animalcare.R;

import java.io.File;
import java.util.ArrayList;

public class ReadBook extends AppCompatActivity {

    ListView lv_pdf;
    public  static ArrayList<File> files = new ArrayList<>();
    PDFAdapter obj_adapter;
    public static  int REQUEST_PERMISSION = 1;
     boolean boolean_permission;
     File dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);

        lv_pdf = findViewById(R.id.listView_pdf);

        dir = new File(Environment.getExternalStorageDirectory().toString());

        pervission_fn();

        lv_pdf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),ViewPDFFiles.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    private void pervission_fn() {

        if ((ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {

            if ((ActivityCompat.shouldShowRequestPermissionRationale(ReadBook.this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE))) {
            } else {
                ActivityCompat.requestPermissions(ReadBook.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_PERMISSION);
            }
        } else {
            boolean_permission = true;
            getfile(dir);
            obj_adapter = new PDFAdapter(getApplicationContext(), files);
            lv_pdf.setAdapter(obj_adapter);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                boolean_permission = true;
                getfile(dir);
                obj_adapter = new PDFAdapter(getApplicationContext(), files);
                lv_pdf.setAdapter(obj_adapter);
            }
            else {
                Toast.makeText(this, "Please Allow the Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public ArrayList<File> getfile(File dir) {
        File listFile [] = dir.listFiles();

        if (listFile != null && listFile.length>0) {

            for(int i= 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    getfile(listFile[i]);
                }
                else {
                    boolean booleanpdf = false;

                    if (listFile[i].getName().endsWith(".pdf")) {

                        for (int j =0; j < files.size(); j++) {

                            if (files.get(j).getName().equals(listFile[i].getName())){
                                booleanpdf = true;
                            }
                            else {

                            }
                        }

                        if (booleanpdf) {
                            booleanpdf = false;
                        }

                        else {
                            files.add(listFile[i]);
                        }
                    }
                }
            }
        }
        return files;
    }
}
