package com.example.city_bus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BusesDatabase extends SQLiteOpenHelper {

    //   Create Database

    public BusesDatabase(@Nullable Context context) {

        super(context, "CityBusDatabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "CREATE TABLE Buses(BUS_ID INTEGER PRIMARY KEY AUTOINCREMENT, BUS_NO INTEGER, BUS_STARTLOCATION TEXT, BUS_ENDLOCATION TEXT, BUS_TIME INTEGER, BUS_DISTANCE TEXT, BUS_ROUTENAME TEXT)";
        db.execSQL(create);
        String create2 = "CREATE TABLE Places(PLACE_ID INTEGER PRIMARY KEY AUTOINCREMENT, PLACE TEXT)";
        db.execSQL(create2);
        String stops = "CREATE TABLE Stops(STOP_ID INTEGER PRIMARY KEY AUTOINCREMENT, BUS_NO INTEGER, ROUTE_NAME TEXT, STOP TEXT)";
        db.execSQL(stops);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public boolean InsertData(int bus_no, String bus_startlocations, String bus_endlocation, int bus_time, String bus_distance, String bus_routename){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("BUS_NO",bus_no);
        contentValue.put("BUS_STARTLOCATION",bus_startlocations);
        contentValue.put("BUS_ENDLOCATION",bus_endlocation);
        contentValue.put("BUS_TIME",bus_time);
        contentValue.put("BUS_DISTANCE",bus_distance);
        contentValue.put("BUS_ROUTENAME",bus_routename);
        long result = db.insert("Buses",null,contentValue);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }


    public Cursor GetAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM Buses", null);
        return cur;
    }

    public boolean InsertPlace(String Place){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("PLACE",Place);
        long result = db.insert("Places",null,contentValue);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public Cursor GetAllDataPlace(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM Places", null);
        return cur;

    }


    public List<String> getAllPlaces() {
        List<String> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Places", null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));//adding 2nd column data

            }
            while (cursor.moveToNext());
        }

        return list;

    }


    public List<String> getbusno() {
        List<String> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Buses", null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));//adding 2nd column data

            }
            while (cursor.moveToNext());
        }

        return list;

    }



    public List<String> getroutename() {

        List<String> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Buses", null);

        // Looping Through All Rows And Adding To List

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(6));//Adding 2nd Column Data

            }
            while (cursor.moveToNext());
        }

        return list;

    }



    public boolean InsertStops(int bus_no, String route_name, String stop){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("BUS_NO",bus_no);
        contentValue.put("ROUTE_NAME",route_name);
        contentValue.put("STOP",stop);
        long result = db.insert("Stops",null,contentValue);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }


}
