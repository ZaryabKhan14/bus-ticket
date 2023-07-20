package com.example.busticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class AdminHomeacticity extends AppCompatActivity {


    Toolbar tb;
    NavigationView nb;
    DrawerLayout dol;
    TabLayout tl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homeacticity);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));


        tb = (Toolbar) findViewById(R.id.admintoolbar);
        nb = (NavigationView) findViewById(R.id.navabr);
        dol = (DrawerLayout) findViewById(R.id.dazar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,dol,tb,R.string.open,R.string.close);
        dol.addDrawerListener(toggle);
        toggle.syncState();

        Fragment near = new Adminhomedesign();
        getSupportFragmentManager().beginTransaction().replace(R.id.adminfram,near).commit();


        nb.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.one){
                    Intent o = new Intent(AdminHomeacticity.this,Registrationreycleview.class);
                    startActivity(o);
                }

                else if(item.getItemId() == R.id.two){
                    Intent a = new Intent(AdminHomeacticity.this,adminrecycleviewacticity.class);
                    startActivity(a);
                }

                return true;
            }
        });






    }




}