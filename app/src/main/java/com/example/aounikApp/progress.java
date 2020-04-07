package com.example.aounikApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class progress extends AppCompatActivity {
    private DatabaseReference orders;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        orders = FirebaseDatabase.getInstance().getReference("Order");
        order order = new order();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);// initiate the progress bar
        String id = OrderPage.order_id;
        orders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Toast.makeText(providerMap.this, result, Toast.LENGTH_LONG).show();
                //Reem
                String id = OrderPage.order_id;
                Toast.makeText(progress.this, id, Toast.LENGTH_LONG).show();

                for (DataSnapshot s : dataSnapshot.getChildren()) {
                    if (s.getKey().equals(id)) {
                        int status = dataSnapshot.child("status").getValue(int.class);

                        if (status == 0) {
                            progressBar.setProgress(0);
                        }
                        if (status == 1) {
                            progressBar.setProgress(30);
                        }
                        if (status == 2) {
                            progressBar.setProgress(50);
                        }
                        if (status == 3) {
                            progressBar.setProgress(70);
                        }
                        if (status == 4) {
                            progressBar.setProgress(100);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
