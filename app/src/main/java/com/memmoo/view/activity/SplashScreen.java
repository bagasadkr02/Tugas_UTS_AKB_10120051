package com.memmoo.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;


import com.memmoo.R;
// 10120051
// Muhammad Bagas Adikara
// IF - 2
public class SplashScreen extends AppCompatActivity  {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            // inisialisasi view
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
            // Hide ActionBar
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            // timer
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }, 2000);
        }

    }