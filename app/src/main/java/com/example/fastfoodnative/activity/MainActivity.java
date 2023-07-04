package com.example.fastfoodnative.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fastfoodnative.R;
import com.example.fastfoodnative.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        HandleFirstReplace();
    }

    private void HandleFirstReplace() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, homeFragment).commit();
    }

    private void Mapping() {
        homeFragment = new HomeFragment();
    }
}