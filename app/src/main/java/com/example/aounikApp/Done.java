package com.example.aounikApp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Done extends AppCompatActivity {
    int new_status = 4;
    private DatabaseReference orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        orders = FirebaseDatabase.getInstance().getReference("Order");

    }
    public void  btn_notify(View view) {

        orders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Toast.makeText(providerMap.this, result, Toast.LENGTH_LONG).show();
                String id = OrderPage.order_id;
                Toast.makeText(Done.this, id, Toast.LENGTH_LONG).show();

                for (DataSnapshot s : dataSnapshot.getChildren()) {
                    if (s.getKey().equals(id)) {

                        //  s.getRef().child("id").child("status").setValue(new_status);

                        Map<String, Object> result = new HashMap<>();
                        result.put("status", new_status);
                        orders.child(id).updateChildren(result);

                        sendNotification();
                        Toast.makeText(Done.this, "status updated", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Done.this,Rating.class);
                        startActivity(intent);
                    }}}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }





        });



    }
    private void sendNotification() {

        // Toast.makeText(this, "Current Recipients is : 1617367 ( Just For Demo )", Toast.LENGTH_SHORT).show();
        // Toast.makeText(this, OrderPage.idOnesignal, Toast.LENGTH_SHORT).show();
        Log.e("asdsa", OrderPage.idOnesignal);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String send_email;

                    //This is a Simple Logic to Send Notification different Device Programmatically....

                    try {
                        String jsonResponse;

                        URL url = new URL("https://onesignal.com/api/v1/notifications");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setUseCaches(false);
                        con.setDoOutput(true);
                        con.setDoInput(true);

                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setRequestProperty("Authorization", "Basic MzhlYWRkNzQtZTdjOC00NGE3LTg2OWUtM2E1ZWZhMmFkNzc4");
                        con.setRequestMethod("POST");

                        String strJsonBody = "{"
                                + "\"app_id\": \"bc201ed5-a81c-4e8e-ad8d-238136133934\","

                                + "\"include_player_ids\": [\"" + OrderPage.idOnesignal + "\"],"
                                //   +   "\"included_segments\": [\"All\"],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \"Thank you\"}"
                                + "}";


                        System.out.println("strJsonBody:\n" + strJsonBody);

                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                        con.setFixedLengthStreamingMode(sendBytes.length);

                        OutputStream outputStream = con.getOutputStream();
                        outputStream.write(sendBytes);

                        int httpResponse = con.getResponseCode();
                        System.out.println("httpResponse: " + httpResponse);

                        if (httpResponse >= HttpURLConnection.HTTP_OK
                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        } else {
                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        }
                        System.out.println("jsonResponse:\n" + jsonResponse);

                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });


    }

}
