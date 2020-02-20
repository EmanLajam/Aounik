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
        resturantNamef = (TextView) findViewById(R.id.newrequest);
        resturantNamef.setText(result);


        phone = (EditText) findViewById(R.id.phoneID);
        desc = (EditText) findViewById(R.id.desID);
        date = (EditText) findViewById(R.id.dateID);
        send = (TextView) findViewById(R.id.sendID);
        resturantName = (TextView) findViewById(R.id.newrequest);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Order");


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createOrder();
            }


        });
    }

    private void createOrder(){

        String Phone = phone.getText().toString();
        String date_order = date.getText().toString();
        String description = desc.getText().toString();

        if(!date_order.isEmpty() && !description.isEmpty() ){

            String id = databaseReference.push().getKey();
            order new_order = new order(id, Phone, date_order, description);
            databaseReference.child(id).setValue(new_order);
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
           Intent s = new Intent(getApplicationContext(), MapsActivity.class);
           startActivity(s);
        }else{
            Toast.makeText(this,"You should enter the empity fields!",Toast.LENGTH_LONG).show();
        }

    }
}


