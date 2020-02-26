package com.example.aounikApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderPage extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    String phone;
    String des;
    String name;
    String date;
    DatabaseReference databaseReference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Order");

        textView = (TextView)findViewById(R.id.Date_order);
        textView2 = (TextView)findViewById(R.id.Mobile_number_req);
        textView3= (TextView)findViewById(R.id.description_req);
        textView4 = (TextView)findViewById(R.id.Restaurant_name);
        name = getIntent().getStringExtra("id");
        textView4.setText(name);


        date = getIntent().getStringExtra("date");
        textView.setText(date);
        phone = getIntent().getStringExtra("phone");
        textView2.setText(phone);
        des = getIntent().getStringExtra("des");
        textView3.setText(des);
       /* Intent services = new Intent(getApplicationContext(), Services.class);
        startActivity(services);*/
    }




}
