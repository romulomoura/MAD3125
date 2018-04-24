package com.example.macstudent.parkingticket.db;

/**
 * Created by macstudent on 2018-04-13.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by macstudent on 2017-11-30.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "carService";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DBCarService.TABLE_SERVICE + "("
                + DBCarService.KEY_ID + " INTEGER PRIMARY KEY," + DBCarService.KEY_DATE + " TEXT,"
                + DBCarService.KEY_ODOMETER + " TEXT" + DBCarService.KEY_SERVICETYPE + " TEXT"
                + DBCarService.KEY_DESC + " TEXT" + DBCarService.KEY_COST + " TEXT"
                + DBCarService.KEY_NEXTSERVICE + " TEXT" + DBCarService.KEY_NEXTCHANGE + " TEXT"
                + DBCarService.KEY_SERVICESTATION + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);


    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DBCarService.TABLE_SERVICE);


        // Create tables again
        onCreate(db);
    }
}