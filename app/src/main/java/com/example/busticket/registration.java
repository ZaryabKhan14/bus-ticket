package com.example.busticket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class registration extends SQLiteOpenHelper {
    public registration(@Nullable Context context) {
        super(context, "Regisration.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table registration(Id integer primary key autoincrement,name text,cnic text,phone text,pswd text,conpswd text, address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists registration ");


    }

    public boolean regisration(String n,String c,String p,String pd,String cpd,String add){
        SQLiteDatabase hadi = this.getWritableDatabase();
        ContentValues dataaya = new ContentValues();
        dataaya.put("name",n);
        dataaya.put("cnic",c);
        dataaya.put("phone",p);
        dataaya.put("pswd",pd);
        dataaya.put("conpswd",cpd);
        dataaya.put("address",add);

        long registration = hadi.insert("registration", null, dataaya);


        if (registration == -1){
            return false;

        }

        else {

            return true;
        }
    }


    public boolean moblealready(String mob){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor m = db.rawQuery("select * from registration where phone = ?",new String[]{mob});
        if (m.getCount() ==0){

            return true;
        }

        else {

            return false;
        }
    }


    public boolean login(String mobile ,String cpswd ){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from registration where phone = ? and conpswd = ?",new String[]{mobile,cpswd});
        if (c.getCount() > 0)
        {
            return true;
        }

        else {
            return false;
        }
    }


    public Cursor registrationidfetchkaro(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor b = db.rawQuery("select * from registration",null);
        return b;
    }


}
