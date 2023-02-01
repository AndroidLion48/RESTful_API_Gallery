package com.eaglewarrior.gbooks.views;

import android.os.Bundle;
import android.view.View;

import com.eaglewarrior.gbooks.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}
