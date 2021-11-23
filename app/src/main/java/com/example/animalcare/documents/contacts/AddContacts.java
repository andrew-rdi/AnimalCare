package com.example.animalcare.documents.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.animalcare.R;

public class AddContacts extends AppCompatActivity implements View.OnClickListener{

    EditText nameView;
    EditText emailView;
    EditText phoneView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        nameView = findViewById(R.id.add_name);
        emailView = findViewById(R.id.add_email);
        phoneView = findViewById(R.id.add_phone);
        addBtn = findViewById(R.id.add_btn_contacts);

        addBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = nameView.getText().toString();
        String email = emailView.getText().toString();
        String phone = phoneView.getText().toString();

        if (name == null || name.equals("")) {
            Toast t = Toast.makeText(this, R.string.add_name_null, Toast.LENGTH_SHORT);
            t.show();
        } else {
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into tb_contact (name, email, phone) values (?,?,?)",
                    new String[]{name, email, phone});
            db.close();

            finish();
        }
    }
}
