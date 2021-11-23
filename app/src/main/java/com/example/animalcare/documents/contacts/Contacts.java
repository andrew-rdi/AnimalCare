package com.example.animalcare.documents.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.animalcare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Contacts extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    FloatingActionButton addBtn;
    ListView listView;
    ArrayList<ContactVO> datas;

    double initTime;

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        //testBtn = findViewById(R.id.contacts_test_btn);
        addBtn = findViewById(R.id.fab);
        listView = findViewById(R.id.contacts_list);

        //testBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        listView.setOnItemClickListener(this);

        myApplication = (MyApplication)getApplicationContext();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
             myApplication.callPermission = true;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            myApplication.readStoragePermission = true;
        }

        if (!myApplication.callPermission) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 10);
        }

        if (!myApplication.readStoragePermission) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 20);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                myApplication.callPermission = true;
            }
        } else if (requestCode == 20 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                myApplication.readStoragePermission = true;
            }

        }
    }

    @Override
    public void onClick(View v) {
        if (v == addBtn) {
            Intent intent= new Intent(this, AddContacts.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(this, ReadContacts.class);
        intent.putExtra("id", datas.get(position).id);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_contact order by name", null);

        datas = new ArrayList<>();
        while (cursor.moveToNext()) {
            ContactVO vo = new ContactVO();
            vo.id = cursor.getInt(0);
            vo.name = cursor.getString(1);
            vo.email = cursor.getString(2);
            vo.phone = cursor.getString(3);
            vo.photo = cursor.getString(4);
            datas.add(vo);
        }
        db.close();

        ContactListAdapter adapter = new ContactListAdapter(this, R.layout.contact_list_item, datas);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast t = Toast.makeText(this, R.string.contact_back_end, Toast.LENGTH_SHORT);
                t.show();
            } else {
                finish();
            }
            initTime = System.currentTimeMillis();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
