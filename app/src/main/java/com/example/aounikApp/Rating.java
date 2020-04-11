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
    private DatabaseReference mRatingBarCh;
    int user = 1;
    TextView review_count, review_average;
    DatabaseReference addref;

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
                 addref = FirebaseDatabase.getInstance().getReference("Ratings");

                DatabaseReference presenceRef = addref.child(MyAdapter.RequesterId);
                presenceRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists())
                        {
                            Log.e("ItHas", "true");
                            float ratings = dataSnapshot.child(MyAdapter.RequesterId).child("rate")
                                    .getValue(float.class);
                            int count = dataSnapshot.child(MyAdapter.RequesterId).child("count")
                                    .getValue(int.class);



                            float new_rate = ratings + ratingBar.getRating();
                            count += 1;

                            Map<String, Object> result = new HashMap<>();
                            result.put("rate", (new_rate / count));
                            result.put("count", count);
                            addref.child(MyAdapter.RequesterId).updateChildren(result);
                        }
                        else {
                            Log.e("ItHas", "false");
                            Map<String, Object> result = new HashMap<>();
                            result.put("rate", ratingBar.getRating());
                            result.put("count", 1);
                            addref.child(MyAdapter.RequesterId).setValue(result);
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                user++;
                addref.setValue(ratingBar.getRating());
            }
        });

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        // final DatabaseReference mRatingBarCh = rootRef.child("ratings");

        rootRef.child("Ratings").child("reem").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int total = 0,
                        count = 0;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    int rating = dataSnapshot.child("user" + (count + 1)).getValue(Integer.class);
                    total = total + rating;
                    count = count + 1;
                }
                if (count != 0) {
                    ratingBar.setRating(total / count);
                    review_count.setText(count + "");
                    review_average.setText(((float)total / (float)count) + "");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException(); // don't ignore errors
            }
        });

    }
}