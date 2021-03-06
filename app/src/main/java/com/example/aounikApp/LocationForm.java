package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;

public class LocationForm extends AppCompatActivity {
    private EditText comment;
    Button send;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    public static String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_form);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Order");
        TextView textView = findViewById(R.id.location);
        send = (Button) findViewById(R.id.sendBtn);
    Intent intent = getIntent();
    String place = intent.getStringExtra("place");
    textView.setText(place);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                order Order = (order) intent.getSerializableExtra("order_data");
                comment = findViewById(R.id.commentID);
                String locationDes = comment.getText().toString();
                Order.setLocationDes(locationDes);
                String id = databaseReference.push().getKey();
                Order.id = id;
                int status = Order.getStatus();
                Order.Status = status;
                Order.setOnesignalID(OneSignal.getPermissionSubscriptionState().getSubscriptionStatus().getUserId());
                user_id = intent.getStringExtra("user_id");
                Log.e("order_id", user_id);
                Order.setUserID(user_id);
                Order.setPrice(0);
                Order.setTime(0);
                databaseReference.child(id).setValue(Order);
                Toast.makeText(LocationForm.this, "Done", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(LocationForm.this, ThankYou.class);
                startActivity(intent1);
            }
        });
    }


}
