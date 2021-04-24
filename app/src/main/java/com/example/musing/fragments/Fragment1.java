package com.example.musing.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.musing.R;
import com.example.musing.R;
import com.example.musing.activities.SignInActivity;
import com.example.musing.models.User;
import com.example.musing.readings.AnxietyActivity;
import com.example.musing.readings.FocusActivity;
import com.example.musing.readings.GratitudeActivity;
import com.example.musing.readings.ProductivityActivity;
import com.example.musing.readings.SleepReading;
import com.example.musing.readings.YinyangActivity;
import com.example.musing.sessions.Session1;
import com.example.musing.sessions.Session2;
import com.example.musing.sessions.Session3;
import com.example.musing.sessions.Session4;
import com.example.musing.sessions.Session5;
import com.example.musing.sessions.Session6;
import com.example.musing.sleepReadings.SleepReading1;
import com.example.musing.sleepReadings.SleepReading2;
import com.example.musing.sleepReadings.SleepReading3;
import com.example.musing.sleepReadings.SleepReading4;
import com.example.musing.sleepReadings.SleepReading5;
import com.example.musing.sleepReadings.SleepReading6;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fragment1 extends Fragment {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView userName;

    User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);
        CardView sleep = (CardView) v.findViewById(R.id.sleep);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
        userName = v.findViewById(R.id.userName);

        CardView anxiety = (CardView) v.findViewById(R.id.anxiety);
        CardView yinyang = (CardView) v.findViewById(R.id.yinyang);
        CardView gratitude = (CardView) v.findViewById(R.id.gratitude);
        CardView focus = (CardView) v.findViewById(R.id.focus);
        CardView productivity = (CardView) v.findViewById(R.id.productivity);
        Button logout = v.findViewById(R.id.logout);
        CardView session1 = (CardView) v.findViewById(R.id.session1);
        CardView session2 = (CardView) v.findViewById(R.id.session2);
        CardView session3 = (CardView) v.findViewById(R.id.session3);
        CardView session4 = (CardView) v.findViewById(R.id.session4);
        CardView session5 = (CardView) v.findViewById(R.id.session5);
        CardView session6 = (CardView) v.findViewById(R.id.session6);

        //function to get name
//            getData();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
            }
        });
        session1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent session1Intent = new Intent(getActivity(), Session1.class);
                startActivity(session1Intent);
            }
        });
        session2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session2Intent = new Intent(getActivity(), Session2.class);
                startActivity(session2Intent);
            }
        });

        session3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session3Intent = new Intent(getActivity(), Session3.class);
                startActivity(session3Intent);
            }
        });

        session4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session4Intent = new Intent(getActivity(), Session4.class);
                startActivity(session4Intent);
            }
        });

        session5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session5Intent = new Intent(getActivity(), Session5.class);
                startActivity(session5Intent);
            }
        });
        session6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session6Intent = new Intent(getActivity(), Session6.class);
                startActivity(session6Intent);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleepReading1 = new Intent(getActivity(), SleepReading1.class);
                startActivity(sleepReading1);
            }
        });
        anxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleepReading2 = new Intent(getActivity(), SleepReading2.class);
                startActivity(sleepReading2);
            }
        });
        yinyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleepReading3 = new Intent(getActivity(), SleepReading3.class);
                startActivity(sleepReading3);
            }
        });
        gratitude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleepReading4 = new Intent(getActivity(), SleepReading4.class);
                startActivity(sleepReading4);
            }
        });

        focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleepReading5 = new Intent(getActivity(), SleepReading5.class);
                startActivity(sleepReading5);
            }
        });
        productivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleepReading6 = new Intent(getActivity(), SleepReading6.class);
                startActivity(sleepReading6);
            }
        });
        return v;
    }

//    private void getData() {
//
//        // calling add value event listener method
//        // for getting the values from database.
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//// this method is call to get the realtime
//                // updates in the data.
//                // this method is called when the data is
//                // changed in our Firebase console.
//                // below line is for getting the data from
//                // snapshot of our database.
//
//                String myName = snapshot.getValue(User.class);
//
//                // after getting the value we are setting
//                // our value to our text view in below line.
//                userName.setText(myName);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//                userName.setError("Failed to get Data");
//            }
//        });
//
//    }

}

