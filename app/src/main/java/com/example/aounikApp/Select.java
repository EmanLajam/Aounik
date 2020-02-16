package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select extends AppCompatActivity {
    Button btnRegster , btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        btnRegster = (Button) findViewById(R.id.btnRegster);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnRegster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(),Regster.class);
               startActivity(s);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(),LoginActivity.class);
               startActivity(s);
            }
        });








    }
}
