package com.example.musing.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.example.musing.R;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class Onboarding extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private static int ONBOARDING_SCREEN_TIME_OUT = 10000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Onboarding.this, ParentActivity.class);
                startActivity(i);
                finish();
            }
        }, ONBOARDING_SCREEN_TIME_OUT);

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataOnboarding());
//fragmentmanager handle transactions between fragments

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();


    }

    private ArrayList<PaperOnboardingPage> getDataOnboarding() {

        PaperOnboardingPage src1 = new PaperOnboardingPage("Meditation", "Helping people to get into mood for Mindfulness.",
                Color.parseColor("#469EF7"), R.drawable.floatingguru, R.drawable.iconapp);
        PaperOnboardingPage src2 = new PaperOnboardingPage("Music", "Listen to deep and relaxing Meditation guide and music",
                Color.parseColor("#469EF7"), R.drawable.musicicon, R.drawable.iconapp);
        PaperOnboardingPage src3 = new PaperOnboardingPage("Achieve", "Make a radical change in your life to achieve Greatness",
                Color.parseColor("#469EF7"), R.drawable.achieve, R.drawable.iconapp);
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(src1);
        elements.add(src2);
        elements.add(src3);
        return elements;
    }

}