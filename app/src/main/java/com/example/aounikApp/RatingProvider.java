package com.example.aounikApp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class RatingProvider extends AppCompatActivity {


    RatingBar ratingBar;
    Button btsubmit;
    private DatabaseReference mRatingBarCh;
    DatabaseReference addref;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_provider);
        ratingBar = findViewById(R.id.ratingBar2);
        addref = FirebaseDatabase.getInstance().getReference("Users");

        btsubmit = findViewById(R.id.bt);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot s : dataSnapshot.getChildren()) {
                            if (s.getKey().equals(LoginActivity.UserID)) {
                                //  Log.e("ItHas", "true");
                                float ratings = s.child("rating").getValue(float.class);
                                int count = s.child("count").getValue(int.class);
                                float new_rate = ratings + ratingBar.getNumStars();
                                count++;
                                float total = new_rate / count;
                                Map<String, Object> result = new HashMap<>();
                                result.put("rating", total);
                                result.put("count", count++);
                                addref.child(LoginActivity.UserID).updateChildren(result);
                                Toast.makeText(RatingProvider.this, "Thank you", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RatingProvider.this, Roles.class);
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