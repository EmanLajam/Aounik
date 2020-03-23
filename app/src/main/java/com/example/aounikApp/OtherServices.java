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

public class OtherServices extends AppCompatActivity {
    public EditText phone;
    public EditText desc;
    public EditText date;
    public TextView send;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_services);

        phone = (EditText) findViewById(R.id.other_phoneID);
        desc = (EditText) findViewById(R.id.other_des);
        date = (EditText) findViewById(R.id.other_dateID);
        send = (TextView) findViewById(R.id.other_sendID);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order Order = new order();
                Order.setMoblie( phone.getText().toString());
                Order.setDate(date.getText().toString());
                Order.setDescription(desc.getText().toString());
                Order.setResturantName("Other Services");
                if (!Order.getDate().isEmpty() && !Order.getDescription().isEmpty()) {


                    Intent intent = new Intent(OtherServices.this, MapsActivity.class);
                    intent.putExtra("order_data", Order);
                    startActivity(intent);

                } else {
                    Toast.makeText(OtherServices.this, "You should enter the empty fields!", Toast.LENGTH_LONG).show();

                }}

        });


    }

}
