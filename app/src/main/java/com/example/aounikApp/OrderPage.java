package com.example.aounikApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    TextView textView5;
    TextView textView6;

    String phone;
    String des;
    String name;
    String date;
    Double latitude;
    Double longitude;
    Button goToMap;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Order");
        goToMap = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.Date_order);
        textView2 = (TextView) findViewById(R.id.Mobile_number_req);
        textView3 = (TextView) findViewById(R.id.description_req);
        textView4 = (TextView) findViewById(R.id.Restaurant_name);
        textView5 = (TextView) findViewById(R.id.time);
        final Intent intent = getIntent();
        name = intent.getStringExtra("id");
        textView4.setText(name);
        date = intent.getStringExtra("date");
        textView.setText(date);
        phone = intent.getStringExtra("phone");
        textView2.setText(phone);
        des = intent.getStringExtra("des");
        textView3.setText(des);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Restaurantsmap");


        goToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent ii = new Intent(OrderPage.this, reemMap.class);
                ii.putExtra("name", name);
                startActivity(ii);
                */
                latitude = intent.getDoubleExtra("latitude", 0.0);
                longitude = intent.getDoubleExtra("longitude", 0.0);
                String place = intent.getStringExtra("place");
                String idOnesignal = intent.getStringExtra("idOnesignal");
                intent.setClass(OrderPage.this, providerMap.class);
                intent.putExtra("name", name);
                intent.putExtra("idOnesignal", idOnesignal);
                startActivityForResult(intent, 1);


            }
        });


    }

    //get data from
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK){
//            float time = data.getFloatExtra("time",0);
//            textView5.setText(time);
            int price = data.getIntExtra("price",0);
            textView6.setText(price);
        }}
    }



}
