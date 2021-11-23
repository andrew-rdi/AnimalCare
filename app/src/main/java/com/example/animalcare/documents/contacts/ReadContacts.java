package com.example.animalcare.documents.contacts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animalcare.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ReadContacts extends AppCompatActivity {

    ImageView contactImage;
    TextView nameView;
    TextView phoneView;
    TextView emailView;

    int contactId;

    ListView listView;
    ArrayList<HashMap<String, String>> scoreList;
    SimpleAdapter sa;

    RadioGroup gradeGroup;
    RadioGroup subjectGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contacts);

        final Intent intent = getIntent();
        contactId = intent.getIntExtra("id",1);

        contactImage = findViewById(R.id.read_contact_image);
        nameView = findViewById(R.id.read_name);
        phoneView = findViewById(R.id.read_phone);
        emailView = findViewById(R.id.read_email);

        listView = findViewById(R.id.read_list);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_contact where _id=" +contactId, null);

        String photo = null;
        while (cursor.moveToNext()) {
            nameView.setText(cursor.getString(1));
            emailView.setText(cursor.getString(2));
            phoneView.setText(cursor.getString(3));
            photo = cursor.getString(4);
        }


        scoreList = new ArrayList<>();
        Cursor scoreCursor = db.rawQuery("select subject, grade, date from tb_grade where contact_id=? order by date desc",
                new String[]{String.valueOf(contactId)});

        while (scoreCursor.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("subject", scoreCursor.getString(0));
            map.put("grade", scoreCursor.getString(1));
            Date d = new Date(Long.parseLong(scoreCursor.getString(2)));
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            map.put("date", sd.format(d));
            scoreList.add(map);
        }

        sa = new SimpleAdapter(this, scoreList, R.layout.read_list_item, new String[]{"subject", "grade", "date"},
                new int[]{R.id.read_list_subject, R.id.read_list_score, R.id.read_list_date});

        listView.setAdapter(sa);
        db.close();

        if (photo != null && !photo.equals("")) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 10;
            Bitmap bitmap = BitmapFactory.decodeFile(photo, options);
            if (bitmap != null) {
                contactImage.setImageBitmap(bitmap);
            }
        }

        contactImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication myApplication = (MyApplication)getApplicationContext();
                if (myApplication.readStoragePermission) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                    intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 10);
                } else {
                    Toast t = Toast.makeText(ReadContacts.this, R.string.permission_error, Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && requestCode == RESULT_OK) {
            try {
                String[] projection = {MediaStore.Images.Media.DATE_ADDED};

                Cursor cursor = getContentResolver().query(data.getData(), projection, null, null, MediaStore.Images.Media.DATE_MODIFIED + "desc");
                cursor.moveToFirst();

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 10;
                Bitmap bitmap = BitmapFactory.decodeFile(cursor.getString(0), options);

                if (bitmap != null) {
                    contactImage.setImageBitmap(bitmap);
                }

                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("update tb_contact set photo=? where _id=?", new String[]{cursor.getString(0), String.valueOf(contactId)});
                db.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_read, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_read_score_add) {
            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View root = inflater.inflate(R.layout.dialog_add_grade, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("GRADE");

            gradeGroup = root.findViewById(R.id.dialog_grade);
            subjectGroup = root.findViewById(R.id.dialog_subject);

            builder.setView(root);
            builder.setPositiveButton("ADD", dialogListener);
            builder.setNegativeButton("Cancel", null);

            builder.create().show();
        } else if (id == R.id.menu_read_sms){
            String phone = phoneView.getText().toString();
            if (phone != null && !phone.equals("")) {
                if (scoreList.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    int count = 0;
                    for (HashMap<String, String> map : scoreList) {
                        count++;
                        sb.append(map.get("subject")+":"+ map.get("date")+":"+ map.get("grade"));
                        sb.append("/");
                        if (count == 3) break;
                    }

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"+phone));
                    intent.putExtra("sms_body", sb.toString());
                    startActivity(intent);
                } else {
                    Toast t = Toast.makeText(this, "has no data", Toast.LENGTH_SHORT);
                    t.show();
                }
            } else {
                Toast t = Toast.makeText(this, "has no phone number", Toast.LENGTH_SHORT);
                t.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String choiceSubject = ((RadioButton)subjectGroup.findViewById(subjectGroup.getCheckedRadioButtonId())).getText().toString();
            String choiceGrade = ((RadioButton)gradeGroup.findViewById(gradeGroup.getCheckedRadioButtonId())).getText().toString();

            DBHelper helper = new DBHelper(ReadContacts.this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into tb_grade (contact_id, subject, date, grade) values (?,?,?,?)",
                    new String[]{String.valueOf(contactId),choiceSubject, String.valueOf(System.currentTimeMillis()), choiceGrade});
            db.close();

            HashMap<String, String> map = new HashMap<>();
            map.put("subject", choiceSubject);
            map.put("grade", choiceGrade);
            Date d = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            map.put("date", sd.format(d));
            scoreList.add(0, map);
            sa.notifyDataSetChanged();
        }
    };

}
