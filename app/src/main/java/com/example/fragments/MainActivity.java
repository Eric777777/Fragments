package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bar_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new HomeFrag()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFrag = null;

            switch (menuItem.getItemId()) {
                case R.id.home_id:
                    selectedFrag = new HomeFrag();
                    break;
                case R.id.search_id:
                    selectedFrag = new SearchFrag();
                    break;

                case R.id.message_id:
                    selectedFrag = new MessageFrag();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, selectedFrag).commit();
            return true;
        }
    };
}

