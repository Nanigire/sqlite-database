package com.example.kvanamacair4.asynctask.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kvanamacair4.asynctask.model.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME="UserDataBase";

    private static final int DATABASE_VERSION = 1;



    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(User.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+User.TABLE_NAME);
        onCreate(db);

    }


}

