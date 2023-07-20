package com.example.busticket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {


    public database(@Nullable Context context) {
        super(context, "Added_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table Addnear(ID integer primary key autoincrement,nearnaem text)");
        sqLiteDatabase.execSQL("create table Addbus(ID integer primary key autoincrement,busname text)");
        sqLiteDatabase.execSQL("create table Addmini(ID integer primary key autoincrement,mininame text)");
        sqLiteDatabase.execSQL("create table Addcoach(ID integer primary key autoincrement,coachname text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists registration ");
        sqLiteDatabase.execSQL("drop table if exists Addnear");
        sqLiteDatabase.execSQL("drop table if exists Addbus");
        sqLiteDatabase.execSQL("drop table if exists Addmini");
        sqLiteDatabase.execSQL("drop table if exists Addcoach");
    }








    public boolean insert(String near) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("nearnaem", near);
        long peter = db.insert("Addnear", null, data);
        if (peter > 0) {
            return true;
        } else {
            return false;
        }


    }





    public List<String> address() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from Addnear", null);
        List<String> addressname = new ArrayList<>();
        while (c.moveToNext()) {

            addressname.add(c.getString(1));
        }

        return addressname;
    }


    public List<String> busadd() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from Addbus", null);
        List<String> busadd = new ArrayList<>();
        while (c.moveToNext()) {

            busadd.add(c.getString(1));
        }

        return busadd;
    }


}










