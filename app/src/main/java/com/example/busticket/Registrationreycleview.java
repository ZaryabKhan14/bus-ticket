package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Registrationreycleview extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationreycleview);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        rv = (RecyclerView) findViewById(R.id.registrationreycleview);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<userregisration> arrayList = new ArrayList<>();
        registration db = new registration(this);
        Cursor cn = db.registrationidfetchkaro();

        if (cn.getCount() == 0){
            Toast.makeText(Registrationreycleview.this, "No Record", Toast.LENGTH_SHORT).show();

        }

        else {
            while (cn.moveToNext()){

                int id = cn.getInt(0);
                String name = cn.getString(1);
                String cnic = cn.getString(2);
                String phone = cn.getString(3);
                String pswd = cn.getString(4);
                String cpswd = cn.getString(5);
                String addr = cn.getString(6);

                userregisration userregisration = new userregisration(id,name,cnic,phone,pswd,cpswd,addr);
                 arrayList.add(userregisration);
            }

            regisrationjadapter regisrationjadapter = new regisrationjadapter(arrayList);
            rv.setAdapter(regisrationjadapter);

        }

    }
}