package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

public class Bookseats extends AppCompatActivity {

    Spinner spi,sp2,sp3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookseats);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        spi = (Spinner) findViewById(R.id.buspiner);
        sp2 = (Spinner) findViewById(R.id.minibusspiner);
        sp3 = (Spinner) findViewById(R.id.coachspiner);
        database db = new database(this);

        List<String> bus = db.busadd();
        ArrayAdapter<String> data = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,bus);
        data.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spi.setAdapter(data);





    }
}