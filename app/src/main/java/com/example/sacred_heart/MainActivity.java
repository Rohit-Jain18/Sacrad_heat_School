package com.example.sacred_heart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMEOUT = 2000;  // Duration of splash screen
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize logo ImageView
        logoImageView = findViewById(R.id.logoImageView);

        // Load animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        // Apply animations to logo
        logoImageView.setVisibility(ImageView.VISIBLE);  // Make logo visible for animation
        logoImageView.startAnimation(fadeIn);  // Apply fade-in effect
        logoImageView.startAnimation(scaleUp); // Apply scale-up effect

        // Transition to next activity after the timeout
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Navdrawer.class);
                startActivity(intent);
                finish();  // Finish this activity to avoid going back to it
            }
        }, SPLASH_SCREEN_TIMEOUT);

        // Handle system bars insets to avoid UI overlap

    }
}
