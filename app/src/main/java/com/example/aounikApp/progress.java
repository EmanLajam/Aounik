package com.example.aounikApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import android.view.View;

public class progress extends AppCompatActivity {
    private DatabaseReference orders;
    ProgressBar progressBar;
    TextView price;
    TextView time;
    TextView provider_name;
    TextView provider_phone;
    TextView provider_rate;
    TextView progress;
    private DatabaseReference users;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        orders = FirebaseDatabase.getInstance().getReference("Order");
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);// initiate the progress bar
        price = findViewById(R.id.price2);
        price.setText(providerMap.priceString);
        time = findViewById(R.id.time2);
        time.setText(providerMap.timeString);
        provider_name = findViewById(R.id.name2);
        provider_phone = findViewById(R.id.phone2);
        provider_rate = findViewById(R.id.rate);
        cancel = findViewById(R.id.cancel);
        progress = findViewById(R.id.progress);
        users = FirebaseDatabase.getInstance().getReference("Users");


        users.addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
         for (DataSnapshot s : dataSnapshot.getChildren()) {
             String id = LoginActivity.UserID;
             if (s.getKey().equals(id)) {
                 String name = s.child("username").getValue(String.class);
                 provider_name.setText(name);
                 String phone = s.child("phone").getValue(String.class);
                 provider_phone.setText(phone);
                 float rate = s.child("rating").getValue(float.class);
                 String rateString = Float.toString((int) Math.round(rate));
                 provider_rate.setText(rateString);
                                                         }
                                                     }
                                                 }
               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

          }
        });


                    orders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Toast.makeText(providerMap.this, result, Toast.LENGTH_LONG).show();
                //Reem
                String id = OrderPage.order_id;
                Toast.makeText(progress.this, id, Toast.LENGTH_LONG).show();

                for (DataSnapshot s : dataSnapshot.getChildren()) {
                    if (s.getKey().equals(id)) {
                        int status = s.child("status").getValue(int.class);

                        if (status == 0) {
                            progressBar.setProgress(0);
                            break;

                            }
                        if (status == 1) {
                            progressBar.setProgress(30);
                            progress.setText("under processing");
                            break;


                            }
                        if (status == 2) {
                            progressBar.setProgress(50);
                            progress.setText("provider has recieved the order and she is coming");

                            break;
                        }
                        if (status == 3) {
                            progressBar.setProgress(70);
                            progress.setText("provider has arrived");

                            break;
                        }
                        if (status == 4) {
                            progressBar.setProgress(100);
                            progress.setText("Done");

                            Intent intent = new Intent(progress.this,RatingProvider.class);
                            startActivity(intent);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
}          public void  btn_cancel(View view) {
        orders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot s : dataSnapshot.getChildren()) {
                    String id = OrderPage.order_id;

                    if (s.getKey().equals(id)) {
                        if (s.child("status").getValue(int.class) == 1) {
                            Map<String, Object> result = new HashMap<>();
                            result.put("status", 0);
                            orders.child(id).updateChildren(result);
                        } else{
                            Toast.makeText(progress.this, "you can't cancel the order", Toast.LENGTH_LONG).show();

                        }
                }
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    }