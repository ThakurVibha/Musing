package com.example.musing.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musing.R;
import com.example.musing.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    EditText name;
    Button saveBtn;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;
    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    // creating a variable for
    // our object class
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        name = findViewById(R.id.edit_text_name);
        saveBtn=findViewById(R.id.saveBtn);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("users");
        // initializing our object
        // class variable.
        user = new User();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validatename()) {
                    String userName = name.getText().toString();

                    addDatatoFirebase(userName);

                    Intent intent = new Intent(UserProfile.this, ParentActivity.class);
                    startActivity(intent);
                } else {
                    return;
                }
            }
        });
    }

    private void addDatatoFirebase(String name) {
        user.setName(name);
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        // inside the method of on Data change we are setting
        // our object class to our database reference.
        // data base reference will sends data to firebase.
        databaseReference.setValue(user);
        // after adding this data we are showing toast message.
        Toast.makeText(UserProfile.this, "Congrats you are Added (: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {
// if the data is not added or it is cancelled then
        // we are displaying a failure toast message.
        Toast.makeText(UserProfile.this, "Hmmm! We are unable to save your name", Toast.LENGTH_SHORT).show();
    }
});
    }


    private boolean validatename() {
        String userName = name.getText().toString();
        if (userName.isEmpty()) {
            name.setError("Please fill your name to proceed further");
            return false;
        } else if (userName.length() > 12) {
            name.setError("Name can not be more than 12 alphabets");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }
}