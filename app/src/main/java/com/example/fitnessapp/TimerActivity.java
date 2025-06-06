package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private TextView timerText;
    private int seconds = 0;
    private boolean running = false;
    private final Handler handler = new Handler(Looper.getMainLooper()); // Ensure Handler is tied to main looper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerText = findViewById(R.id.timerText);
        Button startTimer = findViewById(R.id.startTimer);

        // Start the timer when the button is clicked
        startTimer.setOnClickListener(v -> {
            if (!running) {
                running = true;
                seconds = 0; // Reset the timer when starting
                runTimer();
            }
        });

        // Navigation buttons
        Button toWorkout = findViewById(R.id.toWorkoutFromTimer);
        Button toMain = findViewById(R.id.toMainFromTimer);

        toWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(TimerActivity.this, WorkoutActivity.class);
            startActivity(intent);
        });

        toMain.setOnClickListener(v -> {
            Intent intent = new Intent(TimerActivity.this, MainActivity.class); // Fixed the typo
            startActivity(intent);
        });
    }

    private void runTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    timerText.setText(String.valueOf(seconds));
                    seconds++;
                    handler.postDelayed(this, 1000); // Update every second
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false; // Stop the timer when the activity is paused
        handler.removeCallbacksAndMessages(null); // Clear any pending timer updates
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null); // Clean up to prevent memory leaks
    }
}