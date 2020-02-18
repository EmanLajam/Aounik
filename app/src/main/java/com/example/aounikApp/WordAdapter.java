package com.example.aounikApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.wordViewHolder> {
    public ArrayList<WordClass> mWordList;
    public WordAdapter(ArrayList<WordClass> wordList) {
        mWordList = wordList;
    }

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int posistion);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }



    public static class wordViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageview;
        public TextView mText1;
        public TextView mText2;
        public wordViewHolder(@NonNull View itemView , final OnItemClickListener listener) {
            super(itemView);
            mImageview = itemView.findViewById(R.id.image_view);
            mText1 = itemView.findViewById(R.id.text1);
            mText2 = itemView.findViewById(R.id.text2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }


                }
            });
        }
    }
    @NonNull
    @Override
    public wordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        //call custom item and connect it with holder
        wordViewHolder v = new wordViewHolder(view, mListener);
        return v;
    }
    @Override
    public void onBindViewHolder(@NonNull wordViewHolder wordViewHolder, int position) {
        //pass the values into the views
        WordClass currentWord = mWordList.get(position);
        wordViewHolder.mImageview.setImageResource(currentWord.getmImageView());
        wordViewHolder.mText1.setText(currentWord.getmTextView1());
        wordViewHolder.mText2.setText(currentWord.getmTextview2());
    }
    @Override
    public int getItemCount() {
        //count the number items in the RV
        return mWordList.size();
    }
}