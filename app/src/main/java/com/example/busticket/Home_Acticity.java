package com.example.busticket;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home_Acticity extends AppCompatActivity {

    Toolbar tb;
    NavigationView nv;
    DrawerLayout dol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acticity);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        tb = (Toolbar) findViewById(R.id.toolbar);
        nv = (NavigationView) findViewById(R.id.navabr);
        dol = (DrawerLayout) findViewById(R.id.drawer);


        Fragment homefra = new Homefragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fram,homefra).commit();



    }
}