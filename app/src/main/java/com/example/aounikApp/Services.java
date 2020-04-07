package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity {
    private Button ResturantBtn;
    private Button other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);


        ResturantBtn = (Button) findViewById(R.id.coffe);
        other = (Button) findViewById(R.id.other);

        ResturantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent ResturantList = new Intent(getApplicationContext(), Restaurants.class);
                ResturantList.putExtra("user_id", getIntent().getStringExtra("user_id"));
                startActivity(ResturantList);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Other_services = new Intent(getApplicationContext(), OtherServices.class);
                Other_services.putExtra("user_id", getIntent().getStringExtra("user_id"));
                startActivity(Other_services);
            }
        });
    }

}
