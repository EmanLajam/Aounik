package com.example.aounikApp;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;


public class OrderList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<order> orders;
    DatabaseReference databaseReference;
    public static final String EXTRA_DATE="date";
    public static final String EXTRA_DESCRIPTION="des";
    public static final String EXTRA_PHONE="mobile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        orders = new ArrayList<order>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Order");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    orders.add(dataSnapshot1.getValue(order.class));



                }
                MyAdapter adapter = new MyAdapter(OrderList.this, orders);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(OrderList.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });


    }


}


