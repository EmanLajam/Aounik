package com.example.aounikApp;

public class WordClass {


    private int mImageView;
    private String mTextView1;
    private String mTextview2;
    public WordClass(int imageRes, String text1, String text2)
    {
        mImageView = imageRes;
        mTextView1 = text1;
        mTextview2 = text2;
    }
    public int getmImageView() {
        return mImageView;
    }
    public String getmTextView1() {
        return mTextView1;
    }
    public String getmTextview2() {
        return mTextview2;
    }



}
