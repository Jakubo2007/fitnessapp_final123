package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Checkboxes for Cardio and Muscle Training (mutually exclusive)
        CheckBox cardioCheckbox = findViewById(R.id.cardioCheckbox);
        CheckBox muscleCheckbox = findViewById(R.id.muscleCheckbox);

        cardioCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) muscleCheckbox.setChecked(false);
        });

        muscleCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) cardioCheckbox.setChecked(false);
        });

        // Navigation buttons
        Button toMain = findViewById(R.id.toMainFromWorkout);
        Button toTimer = findViewById(R.id.toTimerFromWorkout);

        toMain.setOnClickListener(v -> {
            Intent intent = new Intent(WorkoutActivity.this, MainActivity.class);
            startActivity(intent);
        });

        toTimer.setOnClickListener(v -> {
            Intent intent = new Intent(WorkoutActivity.this, TimerActivity.class);
            startActivity(intent);
        });
    }
}