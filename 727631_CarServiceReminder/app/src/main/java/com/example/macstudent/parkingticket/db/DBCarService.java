package com.example.macstudent.parkingticket.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macstudent on 2018-04-13.
 */


import com.example.macstudent.parkingticket.model.Carservice;

public class DBCarService {
    // Contacts table name
    static final String TABLE_SERVICE = "carservice";

    // Carservice Table Columns names
    static final String KEY_ID = "id";
    static final String KEY_DATE = "serviceDate";
    static final String KEY_ODOMETER = "odometer";
    static final String KEY_SERVICETYPE = "serviceType";
    static final String KEY_DESC = "description";
    static final String KEY_COST = "cost";
    static final String KEY_NEXTSERVICE = "nextService";
    static final String KEY_NEXTCHANGE = "nextChange";
    static final String KEY_SERVICESTATION = "serviceStation";


    private DatabaseHandler databaseHandler;
    private Context context;

    public DBCarService(Context context) {
        this.context = context;
    }

    // Adding new service
    public void addService(Carservice carservice) {
        databaseHandler = new DatabaseHandler(context);

        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, carservice.getId());
        values.put(KEY_DATE, carservice.getServiceDate());
        values.put(KEY_ODOMETER, carservice.getOdometer());
        values.put(KEY_SERVICETYPE, carservice.getServiceType());
        values.put(KEY_DESC, carservice.getDescription());
        values.put(KEY_COST, carservice.getCost());
        values.put(KEY_NEXTSERVICE, carservice.getNextService());
        values.put(KEY_NEXTCHANGE, carservice.getNextChange());
        values.put(KEY_SERVICESTATION, carservice.getServiceStation());

        // Inserting Row
        db.insert(TABLE_SERVICE, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public Carservice getCarservice(int id) {
        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SERVICE, new String[]{KEY_ID,
                        KEY_DATE, KEY_ODOMETER,KEY_SERVICETYPE,KEY_DESC,KEY_COST,KEY_NEXTSERVICE,KEY_NEXTCHANGE,KEY_SERVICESTATION}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Carservice carservice = new Carservice(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4),cursor.getString(5),cursor.getString(6),
                cursor.getString(7),cursor.getString(8));
        // return SERVICE
        return carservice;
    }

    // Getting All Contacts
    public List<Carservice> getAllContacts() {
        databaseHandler = new DatabaseHandler(context);
        List<Carservice> carserviceList = new ArrayList<Carservice>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SERVICE;

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Carservice carservice = new Carservice();
                carservice.setId(Integer.parseInt(cursor.getString(0)));
                carservice.setServiceDate(cursor.getString(1));
                carservice.setOdometer(cursor.getString(2));
                carservice.setServiceType(cursor.getString(3));
                carservice.setDescription(cursor.getString(4));
                carservice.setCost(cursor.getString(5));
                carservice.setNextService(cursor.getString(6));
                carservice.setNextChange(cursor.getString(7));
                carservice.setServiceStation(cursor.getString(8));

                // Adding service to list
                carserviceList.add(carservice);

            } while (cursor.moveToNext());
        }

        // return contact list
        return carserviceList;
    }

    // Getting contacts Count
    public int getServicesCount() {

        databaseHandler = new DatabaseHandler(context);
        String countQuery = "SELECT  * FROM " + TABLE_SERVICE;
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }




}