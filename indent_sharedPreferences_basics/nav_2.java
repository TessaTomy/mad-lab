package com.example.nav_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class nav_2 extends AppCompatActivity implements View.OnClickListener {

    TextView namee;
    TextView maill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nav2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        namee = findViewById(R.id.namee);
        maill = findViewById(R.id.maill);
        Button btnn = findViewById(R.id.btnn);

        btnn.setOnClickListener(this);

        // Fetch data from SharedPreferences
        SharedPreferences sp = getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        String savedName = sp.getString("name", "No Name");
        String savedMail = sp.getString("mail", "No Mail");

        // Display in TextViews
        namee.setText(savedName);
        maill.setText(savedMail);
    }

    @Override
    public void onClick(View view) {

        finish();
    }
}