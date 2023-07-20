package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent o = new Intent(MainActivity.this,user_login.class);
                startActivity(o);
                finish();
            }
        }, 2000);
    }
}