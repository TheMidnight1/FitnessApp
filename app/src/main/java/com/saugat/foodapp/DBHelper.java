package com.saugat.foodapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FoodDeliveryApp.db";
    private static final int DATABASE_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the "users" table
        db.execSQL("CREATE TABLE users (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT," +
                "first_name TEXT," +
                "last_name TEXT," +
                "password TEXT," +
                "confirm_password TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade logic goes here
    }
}
