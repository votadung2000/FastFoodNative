package com.example.fastfoodnative.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.fastfoodnative.R;
import com.example.fastfoodnative.fragment.CartFragment;
import com.example.fastfoodnative.fragment.HeartFragment;
import com.example.fastfoodnative.fragment.HomeFragment;
import com.example.fastfoodnative.fragment.SearchFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment;
    SearchFragment searchFragment;
    HeartFragment heartFragment;
    CartFragment cartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        HandleFirstReplace();

        // Handle count cart
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.nav_bottom_cart);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        HandleReplaceNavBottom();
    }

    private void HandleReplaceNavBottom() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_bottom_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, homeFragment).commit();
                        return true;
                    case R.id.nav_bottom_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, searchFragment).commit();
                        return true;
                    case R.id.nav_bottom_heart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, heartFragment).commit();
                        return true;
                    case R.id.nav_bottom_cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, cartFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    private void HandleFirstReplace() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, homeFragment).commit();
    }

    private void Mapping() {
        bottomNavigationView = findViewById(R.id.main_nav_bottom);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        heartFragment = new HeartFragment();
        cartFragment = new CartFragment();
    }
}