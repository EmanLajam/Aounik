package com.example.aounikApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<WordClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        CreateArrayList();

        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new WordAdapter(list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new WordAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int posistion) {

                String list1Text = list.get(posistion).getmTextView1();
                Intent i = new Intent(Restaurants.this,Forms.class);
                i.putExtra("name", list1Text);
                startActivity(i);

            }
        });
    }
    public void CreateArrayList() {
        list = new ArrayList<>();

        list.add(new WordClass(R.drawable.kanze, "KANS", "Near western gate 1"));
        list.add(new WordClass(R.drawable.manch, "Munch", "Near western gate 1"));
        list.add(new WordClass(R.drawable.piza, "Pizza now", "Engineering building"));
        list.add(new WordClass(R.drawable.panumis, "paninosme", "Building 18"));
        list.add(new WordClass(R.drawable.mochatchno, "mochachino", "Near western gate 1"));
        list.add(new WordClass(R.drawable.kwalite, "Kwality", "Near western gate 1"));
        list.add(new WordClass(R.drawable.coffeshop, "Text1", "Text"));
        list.add(new WordClass(R.drawable.coffeshop, "Text2", "Text"));
        list.add(new WordClass(R.drawable.coffeshop, "Text3", "Text"));
        list.add(new WordClass(R.drawable.coffeshop, "Text4", "Text"));
        list.add(new WordClass(R.drawable.coffeshop, "Text5", "Text"));
        list.add(new WordClass(R.drawable.coffeshop, "Text6", "Text"));

    }
}
