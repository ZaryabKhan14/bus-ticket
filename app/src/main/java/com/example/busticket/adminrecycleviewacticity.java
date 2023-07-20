package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class adminrecycleviewacticity extends AppCompatActivity {

    RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminrecycleviewacticity);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        rc = (RecyclerView) findViewById(R.id.myrecycleview);
        rc.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<adminaddnearandbuses> arrayList = new ArrayList<>();
        busdatabase db = new busdatabase(this);
        Cursor cv = db.idlekajao();

        if (cv.getCount() == 0){
            Toast.makeText(adminrecycleviewacticity.this, "No Record", Toast.LENGTH_SHORT).show();
        }

        else {

            while (cv.moveToNext()){

                int id = Integer.parseInt(cv.getString(0));
                String name = cv.getString(1);
                String buses = cv.getString(2);
                String area = cv.getString(3);


                adminaddnearandbuses adminaddnearandbuses = new adminaddnearandbuses(id,name,buses,area);
                arrayList.add(adminaddnearandbuses);

            }

            adminadapater adminadapater = new adminadapater(arrayList);
            rc.setAdapter(adminadapater);

        }

    }
}