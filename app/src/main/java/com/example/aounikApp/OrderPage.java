package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderPage extends AppCompatActivity {
    TextView textView;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        textView = (TextView)findViewById(R.id.textView2);
        date = getIntent().getStringExtra("name");
        textView.setText(date);
       /* Intent services = new Intent(getApplicationContext(), Services.class);
        startActivity(services);*/
    }




}
