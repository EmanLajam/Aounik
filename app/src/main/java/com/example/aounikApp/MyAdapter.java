package com.example.aounikApp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<order> orders;



    public MyAdapter(Context c,ArrayList<order> res){

        context = c;
        orders = res;

    }
    @NonNull
    @Override
    //THIS fanction determines the page design we will implement the list
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.order_list,parent,false));

    }

    @Override
    //here we control with items
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(orders.get(position).getResturantName());
        holder.date.setText(orders.get(position).getDate());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,OrderPage.class);
                intent.putExtra("order_id",orders.get(position).getId());
                intent.putExtra("id",orders.get(position).getResturantName());
                intent.putExtra("date",orders.get(position).getDate());
                intent.putExtra("idOnesignal",orders.get(position).getOnesignalID());
                intent.putExtra("phone",orders.get(position).getMoblie());
                intent.putExtra("des",orders.get(position).getDescription());
                intent.putExtra("latitude",orders.get(position).getLatitude());
                intent.putExtra("longitude",orders.get(position).getLongitude());

                context.startActivity(intent);

            }
        });

    }
    @Override
    //function to determine size of list
    public int getItemCount() {
        //we dont know what size but we get size from arraylist by function size()
        return orders.size();
    }
    //declear items
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RelativeLayout relativeLayout;
        TextView date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.ordertName);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative);
           date = (TextView) itemView.findViewById(R.id.resturantLocation);

        }


    }}
