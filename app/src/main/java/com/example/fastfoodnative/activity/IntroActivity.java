package com.example.fastfoodnative.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fastfoodnative.R;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Mapping();
        ClickStart();
    }

    private void ClickStart() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }

    private void Mapping() {
        btnStart = findViewById(R.id.intro_btn_start);
    }
}