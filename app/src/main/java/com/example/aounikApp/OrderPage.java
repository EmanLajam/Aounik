package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderPage extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    String date;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        textView = (TextView)findViewById(R.id.name_req);
        textView2 = (TextView)findViewById(R.id.Mobile_number_req);
        date = getIntent().getStringExtra("name");
        textView.setText(date);
        phone = getIntent().getStringExtra("name");
        textView.setText(phone);
       /* Intent services = new Intent(getApplicationContext(), Services.class);
        startActivity(services);*/
    }




}
