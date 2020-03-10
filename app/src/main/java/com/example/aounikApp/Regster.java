package com.example.aounikApp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Regster extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;
    // DatabaseReference university;
    EditText edtUsername, edtPassword, edtMail , editID ,ediphon;
    Button btnSignUp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regster);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.editpassword);
        edtMail = (EditText)findViewById(R.id.ediEmail);
        editID = (EditText)findViewById(R.id.editID);
        ediphon = (EditText) findViewById(R.id.editPhone);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
       /* btnToSignIn = (Button) findViewById(R.id.btnToSingIn);




         btnToSignIn.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
        Intent s = new Intent(getApplicationContext(),LoginActivity.class);
           startActivity(s);
          }
         });
*/
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = new User(edtUsername.getText().toString(),
                        edtPassword.getText().toString(),edtMail.getText().toString(),editID.getText().toString(),ediphon.getText().toString());

                if (edtPassword.getText().toString().trim().isEmpty()|| ediphon.getText().toString().trim().isEmpty()|| edtUsername.getText().toString().trim().isEmpty()
                        ||edtMail.getText().toString().trim().isEmpty()||editID.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Regster.this,"please fill the empty fields .",Toast.LENGTH_SHORT).show();



               /* if (edtPassword.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Regster.this,"Password is empty. Please fill it in .",Toast.LENGTH_SHORT).show();

                }
                if (edtUsername.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Regster.this,"Username is empty. Please fill it in .",Toast.LENGTH_SHORT).show();

                }
                if (edtMail.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Regster.this,"Email is empty. Please fill it in .",Toast.LENGTH_SHORT).show();

                }
                if (editID.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Regster.this,"ID is empty. Please fill it in .",Toast.LENGTH_SHORT).show();

                }
                if (ediphon.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Regster.this,"phone is empty. Please fill it in .",Toast.LENGTH_SHORT).show();
*/
                }

                else {
                    users.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child(user.getID()).exists())
                                Toast.makeText(Regster.this, "the user exist", Toast.LENGTH_SHORT).show();
                            else {
                                users.child(user.getID()).setValue(user);
                                Toast.makeText(Regster.this, "successfully registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });



    }
}
