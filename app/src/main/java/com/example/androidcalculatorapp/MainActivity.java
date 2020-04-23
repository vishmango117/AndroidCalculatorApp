package com.example.androidcalculatorapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            // if you are redirecting from a fragment then use getActivity() as the context.
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Handler h = new Handler();
        h.postDelayed(r,2000);
    }
}
