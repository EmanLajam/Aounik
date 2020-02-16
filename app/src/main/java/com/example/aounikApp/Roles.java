package com.example.aounikApp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Roles extends AppCompatActivity {
    Button btnReq , btnProv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);

        btnProv = (Button) findViewById(R.id.provider);
        btnReq = (Button) findViewById(R.id.requster);

        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Intent s = new Intent(getApplicationContext(), Services.class);
           //     startActivity(s);

            }

        });


        btnProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     Intent s = new Intent(getApplicationContext(), OrderList.class);
            //    startActivity(s);
            }
        });


    }}

