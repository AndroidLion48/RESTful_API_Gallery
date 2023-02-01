package com.eaglewarrior.gbooks.views;

import android.content.Intent;
import android.os.Bundle;

import com.eaglewarrior.gbooks.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
