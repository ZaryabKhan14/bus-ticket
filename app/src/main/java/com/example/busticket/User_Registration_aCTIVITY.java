package com.example.busticket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class User_Registration_aCTIVITY extends AppCompatActivity {

   TextInputLayout ed1,ed2,ed3,ed4,ed5,ed6;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        ed1 = (TextInputLayout) findViewById(R.id.name);
        ed2 = (TextInputLayout) findViewById(R.id.cnic);
        ed3 = (TextInputLayout) findViewById(R.id.phone);
        ed4 = (TextInputLayout) findViewById(R.id.pswd);
        ed5 = (TextInputLayout) findViewById(R.id.cpswd);
        ed6 = (TextInputLayout) findViewById(R.id.address);
        registration db = new registration(this);
        btn = (Button) findViewById(R.id.registration);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ed1.getEditText().getText().toString();
                String cnic = ed2.getEditText().getText().toString();
                String phone = ed3.getEditText().getText().toString();
                String password = ed4.getEditText().getText().toString();
                String conpswd = ed5.getEditText().getText().toString();
                String address = ed6.getEditText().getText().toString();

                AlertDialog.Builder alert = new AlertDialog.Builder(User_Registration_aCTIVITY.this);
                alert.setMessage("Do You To Want Regisration");
                alert.setTitle("Confirmation");
                alert.setIcon(R.drawable.ic_baseline_block_24);

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (password.equals(conpswd)){

                            if (db.moblealready(phone)) {


                                if (db.regisration(name, cnic, phone, password, conpswd, address)) {
                                    Toast.makeText(User_Registration_aCTIVITY.this, "successfully", Toast.LENGTH_SHORT).show();
                                    Intent ii = new Intent(User_Registration_aCTIVITY.this,user_login.class);
                                    startActivity(ii);
                                    finish();

                                } else {
                                    Toast.makeText(User_Registration_aCTIVITY.this, " Not successfully", Toast.LENGTH_SHORT).show();

                                }


                            }

                            else {
                                ed3.setError("Already Exists");
                                ed3.requestFocus();
                            }


                        }

                        else {

                            ed5.setError("Invalid");
                            ed5.requestFocus();
                        }


                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        ed1.getEditText().setText("");
                        ed2.getEditText().setText("");
                        ed3.getEditText().setText("");
                        ed4.getEditText().setText("");
                        ed5.getEditText().setText("");
                        ed6.getEditText().setText("");

                    }
                });

                alert.show();






            }
        });




            }
        }