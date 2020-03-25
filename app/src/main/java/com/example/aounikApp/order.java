package com.example.aounikApp;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class order implements Serializable {
      String id;
      String OnesignalID;
      String UserID;
     private String moblie;
     private String date;
     private String Description;
    private String resturantName;
    private String locationDes;
    private Double Longitude;
    private Double Latitude;
    int Status = 0 ;
    private DatabaseReference orders;

    public void setLocationDes(String locationDes) {
        this.locationDes = locationDes;
    }

    public String getLocationDes() {
        return locationDes;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public order() {
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public order(String id, String OnesignalID, String name, String moblie, String Date, String description, String locationDes , Double longitude, Double latitude , String userID, int status) {
        this.id = id;
        this.OnesignalID = OnesignalID;
        resturantName = name;
        this.moblie = moblie;
        date = Date;
        Description = description;
        this.locationDes = locationDes;
        Latitude = latitude;
        Longitude = longitude;
        UserID = userID;
        Status = status;
    }

    public String getId() {
        return id;
    }

    public String getMoblie() {
        return moblie;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOnesignalID() {
        return OnesignalID;
    }

    public void setOnesignalID(String onesignalID) {
        OnesignalID = onesignalID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
    /*
    public void updateStatus(){
        orders = FirebaseDatabase.getInstance().getReference("Order");

        orders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Toast.makeText(providerMap.this, result, Toast.LENGTH_LONG).show();
//                String id = OrderPage.order_id;
//                Toast.makeText(IamReady.this, id, Toast.LENGTH_LONG).show();

                for (DataSnapshot s : dataSnapshot.getChildren()) {
                    if (s.getKey().equals(id)) {
                        if (getStatus() == 0 ){
                            setStatus(1); ;}

                        if (getStatus() == 1 ){
                            setStatus(2);}
                        if (getStatus() == 2 ){
                            setStatus(3);}
                        //  s.getRef().child("id").child("status").setValue(new_status);

                        Map<String, Object> result = new HashMap<>();
                        result.put("status", getStatus());
                        orders.child(id).updateChildren(result);


                    }}}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }





        });

    }
    */
}
