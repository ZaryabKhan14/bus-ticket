package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Admin_loginformacticity extends AppCompatActivity {

    TextInputLayout ed1,ed2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_loginformacticity);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        ed1 = (TextInputLayout) findViewById(R.id.adminemail);
        ed2 = (TextInputLayout) findViewById(R.id.adminpassword);
        btn = (Button) findViewById(R.id.adminbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed1.getEditText().getText().toString();
                String pswd = ed2.getEditText().getText().toString();

                if (email.equals("Admin@gmail.com") && pswd.equals("123")){

                    Intent o = new Intent(Admin_loginformacticity.this,AdminHomeacticity.class);
                    startActivity(o);
                    finish();
                    Toast.makeText(Admin_loginformacticity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    SharedPreferences shar = getSharedPreferences("credentials",MODE_PRIVATE);
                    SharedPreferences.Editor ed = shar.edit();
                    ed.putString("useremail",email);
                    ed.putString("userpswd",pswd);
                    ed.apply();

                }

                else {
                    Toast.makeText(Admin_loginformacticity.this, "Login Not Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}