package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class filterReycleview extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_reycleview);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));



        rv = (RecyclerView) findViewById(R.id.filterreycleview);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<filteradapter> fil = new ArrayList<>();
        busdatabase db = new busdatabase(this);
        Intent i = getIntent();
        String des = i.getStringExtra("destination");
        Log.e("errorrrrr", des);
        Cursor cm = db.filteridlekajao(des);
        Log.e("errorrrrr2", String.valueOf(cm.getCount()));
        if (cm.getCount() == 0) {
            Toast.makeText(filterReycleview.this, "No Record", Toast.LENGTH_SHORT).show();
        } else {

            while (cm.moveToNext()) {


                String name = cm.getString(3);
                String buses = cm.getString(2);
                String area = cm.getString(1);


                filteradapter filteradapter = new filteradapter(name, buses, area);
                fil.add(filteradapter);

            }

            Filterhumaradapter filterhumaradapter = new Filterhumaradapter(fil);
            rv.setAdapter(filterhumaradapter);

        }


    }


}