package com.example.musing.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.musing.R;
import com.example.musing.music.BirdsChirping;
import com.example.musing.music.FeelGood;
import com.example.musing.music.FocusMusic;
import com.example.musing.music.Motivational;
import com.example.musing.music.Productivity;
import com.example.musing.music.Rain;
import com.example.musing.sleepReadings.SleepReading1;
import com.example.musing.sleepReadings.SleepReading2;
import com.example.musing.sleepReadings.SleepReading3;
import com.example.musing.sleepReadings.SleepReading4;
import com.example.musing.sleepReadings.SleepReading5;
import com.example.musing.sleepReadings.SleepReading6;
import com.example.musing.sleepSessions.SleepSession1;
import com.example.musing.sleepSessions.SleepSession2;
import com.example.musing.sleepSessions.SleepSession3;
import com.example.musing.sleepSessions.SleepSession4;
import com.example.musing.sleepSessions.SleepSession5;
import com.example.musing.sleepSessions.SleepSession6;


public class SleepFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sleep, container, false);
        CardView session1 = v.findViewById(R.id.music1);
        CardView session2 = v.findViewById(R.id.music2);
        CardView session3 = v.findViewById(R.id.music3);
        CardView session4 = v.findViewById(R.id.music4);
        CardView session5 = v.findViewById(R.id.music5);
        CardView session6 = v.findViewById(R.id.music6);

        CardView reading1 = v.findViewById(R.id.music7);
        CardView reading2 = v.findViewById(R.id.music8);
        CardView reading3 = v.findViewById(R.id.music9);
        CardView reading4 = v.findViewById(R.id.music10);
        CardView reading5 = v.findViewById(R.id.music11);
        CardView reading6 = v.findViewById(R.id.music12);

        session1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session1Intent = new Intent(getActivity(), SleepSession1.class);
                startActivity(session1Intent);
            }
        });
        session2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session1Intent = new Intent(getActivity(), SleepSession2.class);
                startActivity(session1Intent);
            }
        });
        session3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session1Intent = new Intent(getActivity(), SleepSession3.class);
                startActivity(session1Intent);
            }
        });
        session4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session1Intent = new Intent(getActivity(), SleepSession4.class);
                startActivity(session1Intent);
            }
        });
        session5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session1Intent = new Intent(getActivity(), SleepSession5.class);
                startActivity(session1Intent);
            }
        });
        session6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent session1Intent = new Intent(getActivity(), SleepSession6.class);
                startActivity(session1Intent);
            }
        });

        reading1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reading1Intent = new Intent(getActivity(), BirdsChirping.class);
                startActivity(reading1Intent);
            }
        });
        reading2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reading2Intent = new Intent(getActivity(), Motivational.class);
                startActivity(reading2Intent);
            }
        });
        reading3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reading3Intent = new Intent(getActivity(), FeelGood.class);
                startActivity(reading3Intent);
            }
        });
        reading4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reading4Intent = new Intent(getActivity(), FocusMusic.class);
                startActivity(reading4Intent);
            }
        });
        reading5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reading5Intent = new Intent(getActivity(), Productivity.class);
                startActivity(reading5Intent);
            }
        });
        reading6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reading6Intent = new Intent(getActivity(), Rain.class);
                startActivity(reading6Intent);
            }
        });
        return v;
    }
}