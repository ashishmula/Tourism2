package com.abhishek.tourism;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txtUsername=findViewById(R.id.txtUsername);
        EditText txtPassword=findViewById(R.id.txtPassword);
        Button btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsername.getText().toString().equals("")||txtPassword.getText().toString().equals("")){
                    AlertDialog.Builder myalert=new AlertDialog.Builder(MainActivity.this);
                    myalert.setTitle("Please Enter username and password to continue");
                    myalert.setNeutralButton("Ok",null);
                    myalert.show();

                }
                else if(txtUsername.getText().toString().equals("User1")&&txtPassword.getText().toString().equals("Password1")){
                    Intent i=new Intent(MainActivity.this,Home.class);
                    startActivity(i);
                }
            }
        });
    }


}