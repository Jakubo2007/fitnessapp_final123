package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checkboxes for ML and L (mutually exclusive)
        CheckBox mlCheckbox = findViewById(R.id.mlCheckbox);
        CheckBox lCheckbox = findViewById(R.id.lCheckbox);

        mlCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) lCheckbox.setChecked(false);
        });

        lCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) mlCheckbox.setChecked(false);
        });

        // Navigation buttons
        Button toWorkout = findViewById(R.id.toWorkout);
        Button toTimer = findViewById(R.id.toTimer);

        toWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
            startActivity(intent);
        });

        toTimer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimerActivity.class);
            startActivity(intent);
        });
    }
}