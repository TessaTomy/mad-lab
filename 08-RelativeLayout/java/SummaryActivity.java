package com.example.pg_08;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvSummary = findViewById(R.id.tvSummary);
        Button btnBack = findViewById(R.id.btnBack);
        ImageView imageView = findViewById(R.id.imageView);

        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String name = prefs.getString("NAME_KEY", "");
        String mail = prefs.getString("MAIL_KEY", "");
        String gender = prefs.getString("GENDER_KEY", "");

        String category = "pg01";
        if (gender.equalsIgnoreCase("Female")) {
            category = "pg02";
            imageView.setImageResource(R.drawable.pg02); // Load pg02 for female
        } else {
            imageView.setImageResource(R.drawable.pg01); // Load pg01 for male/others
        }

        String summaryText = "Name: " + name + "\nMail: " + mail + "\nGender: " + gender;
        tvSummary.setText(summaryText);

        btnBack.setOnClickListener(v -> finish());
    }
}
