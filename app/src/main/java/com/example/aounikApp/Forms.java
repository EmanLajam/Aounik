package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Forms extends AppCompatActivity {


    private EditText phone;
    private EditText desc;
    private EditText date;
    private TextView send;
    private TextView resturantName;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    private TextView resturantNamef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        Intent i = getIntent();
        String result = i.getStringExtra("name");
        resturantNamef = (TextView)findViewById(R.id.newrequest);
        resturantNamef.setText(result);











    }
}
