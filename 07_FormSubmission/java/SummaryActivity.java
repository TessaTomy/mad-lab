package com.example.pg07;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SummaryActivity extends AppCompatActivity {

    TextView tvSummary;
    Button btnBack, btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvSummary = findViewById(R.id.tvSummary);
        btnBack = findViewById(R.id.btnBack);
        btnConfirm = findViewById(R.id.btnConfirm);

        // Fetch data from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        String name = prefs.getString("NAME", "N/A");
        String mail = prefs.getString("MAIL", "N/A");
        String category = prefs.getString("CATEGORY", "N/A");
        String interests = prefs.getString("INTERESTS", "N/A");

        // Display data in TextView
        String summaryText = "Name: " + name + "\n\n" +
                "Mail: " + mail + "\n\n" +
                "Category: " + category + "\n\n" +
                "Interests: " + interests;

        tvSummary.setText(summaryText);

        // Back button action
        btnBack.setOnClickListener(v -> finish());

        // Confirm button action with custom toast
        btnConfirm.setOnClickListener(v -> {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_root));

            TextView tvToast = layout.findViewById(R.id.toast_text);
            tvToast.setText("Welcome, Registration Success!");
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP,0,100);
            toast.setView(layout);
            toast.show();
        });
    }
}