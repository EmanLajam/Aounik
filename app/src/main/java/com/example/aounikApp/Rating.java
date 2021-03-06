package com.example.aounikApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Rating extends AppCompatActivity {


    RatingBar ratingBar;
    Button btsubmit;
    DatabaseReference addref;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ratingBar = findViewById(R.id.ratingBar);
        addref = FirebaseDatabase.getInstance().getReference("Users");

        btsubmit = findViewById(R.id.bt);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot s : dataSnapshot.getChildren()) {
                            if (s.getKey().equals(MyAdapter.RequesterId)) {
                                //  Log.e("ItHas", "true");
                                float ratings = s.child("rating").getValue(float.class);
                                int count = s.child("count").getValue(int.class);
                                float new_rate = ratings + (ratingBar.getRating());
                                count++;
                                float total = new_rate / count;
                                Map<String, Object> result = new HashMap<>();
                                result.put("rating", total);
                                result.put("count", count++);
                                addref.child(MyAdapter.RequesterId).updateChildren(result);
                                Toast.makeText(Rating.this, "Thank you", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Rating.this, Roles.class);
                                startActivity(intent);
                            } else {
                                Log.e("ItHas", "false");

                            }}}


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }
}