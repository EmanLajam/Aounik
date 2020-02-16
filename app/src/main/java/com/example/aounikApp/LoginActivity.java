package com.example.aounikApp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users;
    EditText edtID, edtPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        edtID = (EditText)findViewById(R.id.edtID);
        edtPassword = (EditText)findViewById(R.id.editpassword);


        btnSignIn = (Button) findViewById(R.id.btnSingIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Verify(edtID.getText().toString(),edtPassword.getText().toString());

            }
        });






    }

    private void Verify(final String id, final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(id).exists()){
                    if(!id.isEmpty()){
                        User Login = dataSnapshot.child(id).getValue(User.class);
                        if(Login.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this,"Success Login",Toast.LENGTH_SHORT).show();
                          //  Intent s = new Intent(getApplicationContext(),Roles.class);
                         //   startActivity(s);
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"password is wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this," Username is Not Register",Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
