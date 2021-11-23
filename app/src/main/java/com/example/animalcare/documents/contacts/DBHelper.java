package com.example.animalcare.documents.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "contactdb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String contactSql="create table tb_contact (" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "email," +
                "phone," +
                "photo)";

        String scoreSql="create table tb_grade (" +
                "_id integer primary key autoincrement," +
                "contact_id not null," +
                "subject," +
                "date," +
                "grade)";

        db.execSQL(contactSql);
        db.execSQL(scoreSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_contact");
            db.execSQL("drop table tb_score");
            onCreate(db);
        }
    }

}
