package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    private DatabaseReference mRatingBarCh;
    int user = 0;
    TextView review_count, review_average;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar = findViewById(R.id.ratingBar);
        review_count = findViewById(R.id.review_count);
        review_average = findViewById(R.id.review_average);
        btsubmit = findViewById(R.id.bt);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                // final DatabaseReference mRatingBarCh = rootRef.child("ratings");

                rootRef.child("Users").child("id").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        float  Rating = ratingBar.getRating();
                        float total = 0;
                        float average = 0;
                        String id = getIntent().getStringExtra("user_id");
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            float rating = child.child("rating").getValue(float.class);
                            int Count = child.child("count").getValue(int.class);
                            Count = Count + 1 ;
                            total = Rating + rating;
                            average = total / count;

                            if (child.getKey().equals(id)) {

                                Map<String, Object> result = new HashMap<>();
                                result.put("rating", average);
                                result.put("count", Count);
                                rootRef.child(id).updateChildren(result);
                            }
                            if (Count != 0) {
                                ratingBar.setRating(total / count);
                                review_count.setText(id);
                                review_average.setText((total / Count) + "");
                            }
                        }}

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        throw databaseError.toException(); // don't ignore errors
                    }
                });

            }


        });


}}