package com.example.musing.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.musing.R;
import com.example.musing.fragments.Fragment1;
import com.example.musing.fragments.Fragment2;
import com.example.musing.fragments.SleepFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class ParentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        toolbar = findViewById(R.id.main_toolbar);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        //This class provides a handy way to tie together the functionality of DrawerLayout and the framework ActionBar to implement the recommended design for navigation drawers.
        //
        //To use ActionBarDrawerToggle, create one in your Activity and call through to the following methods corresponding to your Activity callbacks:
        //
        //onConfigurationChanged
        //onOptionsItemSelected
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
//        I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment1()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment2()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.meditation:
                            selectedFragment = new Fragment1();
                            break;
                        case R.id.yoga:
                            selectedFragment = new Fragment2();
                            break;
                        case R.id.sleepMeditation:
                            selectedFragment = new SleepFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.contactDev:
                final Intent intent = new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("to:vibhathakur39@gmail.com"));
                startActivity(intent);
                break;
        }
            return true;
        }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
