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

public class Rating extends AppCompatActivity {


    RatingBar ratingBar;
    Button btsubmit;
    private DatabaseReference mRatingBarCh;
    int user = 1;
    TextView review_count, review_average;


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

                DatabaseReference addref = FirebaseDatabase.getInstance().getReference().child("Ratings").child("reem").child("user" + user);
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