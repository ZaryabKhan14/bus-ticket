package com.example.busticket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class busdatabase extends SQLiteOpenHelper {
    public busdatabase(@Nullable Context context) {
        super(context, "Bus.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Bustable(Id integer primary key autoincrement,busname text,buscate text, busarea text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Bustable ");
    }

    public boolean addbus(String b, String c, String a){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues dataya = new ContentValues();
        dataya.put("busname",b);
        dataya.put("buscate",c);
        dataya.put("busarea",a);

        long khan = db.insert("Bustable",null,dataya);

        if (khan > 0){
            return true;

        }

        else {
            return false;
        }
    }



    public Cursor idlekajao(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cb = db.rawQuery("select * from Bustable",null);
        return cb;
    }
    public Cursor filteridlekajao(String a){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from Bustable where busarea like '%" + a + "%'";
        Cursor cb = db.rawQuery(query,null);
        return cb;
    }

}
