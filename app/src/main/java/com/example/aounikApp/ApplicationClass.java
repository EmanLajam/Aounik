package com.example.aounikApp;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;

public class ApplicationClass extends Application {
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: Add OneSignal initialization here
        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler(this))
                .init();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("User");



    }
}
