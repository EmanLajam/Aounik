package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Forms extends AppCompatActivity {


    public EditText phone;
    public EditText desc;
    public EditText date;
    public TextView send;
    private TextView resturantName;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    private TextView resturantNamef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        order Order = new order();
       final Intent i = getIntent();
        final String result = i.getStringExtra("name");
        resturantNamef = (TextView) findViewById(R.id.newrequest);
        resturantNamef.setText(result);

        phone = (EditText) findViewById(R.id.phoneID);
        desc = (EditText) findViewById(R.id.desID);
        date = (EditText) findViewById(R.id.dateID);
        send = (TextView) findViewById(R.id.sendID);
        resturantName = (TextView) findViewById(R.id.newrequest);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order Order = new order();
              Order.setMoblie( phone.getText().toString());
              Order.setDate(date.getText().toString());
              Order.setDescription(desc.getText().toString());
              Order.setResturantName( resturantNamef.getText().toString());
                if (!Order.getDate().isEmpty() && !Order.getDescription().isEmpty()) {
              Intent intent = new Intent(Forms.this, MapsActivity.class);
              intent.putExtra("order_data", Order);
              startActivity(intent);

            } else {
                    Toast.makeText(Forms.this, "You should enter the empty fields!", Toast.LENGTH_LONG).show();

                }}

        });


    }

    }



