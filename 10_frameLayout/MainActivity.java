package com.example.frame;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    View card1;
    View card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);

        card1.setOnClickListener(v -> {
            card1.setVisibility(View.GONE);
            card2.setVisibility(View.VISIBLE);
        });

        card2.setOnClickListener(v -> {
            card2.setVisibility(View.GONE);
            card1.setVisibility(View.VISIBLE);
        });
    }
}
