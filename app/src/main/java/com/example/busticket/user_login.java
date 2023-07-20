package com.example.busticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class user_login extends AppCompatActivity {

    TextInputLayout ed1,ed2;
    TextView newaccount;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        ed1 = (TextInputLayout) findViewById(R.id.usermobile);
        ed2 = (TextInputLayout) findViewById(R.id.userpswd);
        newaccount = (TextView) findViewById(R.id.createaccountbtn);
        registration db = new registration(this);
        btn = (Button) findViewById(R.id.loginbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mob = ed1.getEditText().getText().toString();
                String cpswd = ed2.getEditText().getText().toString();


                if (db.login(mob,cpswd)){

                    Toast.makeText(user_login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent p = new Intent(user_login.this,Home_Acticity.class);
                    startActivity(p);
                    finish();

                    SharedPreferences shar = getSharedPreferences("kuchbhi",MODE_PRIVATE);
                    SharedPreferences.Editor editor = shar.edit();
                    editor.putString("mob",ed1.getEditText().toString());
                    editor.apply();
                }

                else {
                    Toast.makeText(user_login.this, "Login Not Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });


        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(user_login.this,User_Registration_aCTIVITY.class);
                startActivity(p);
            }
        });



    }
}