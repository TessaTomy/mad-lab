package com.example.pg07;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMail;
    RadioGroup radioGroup;
    CheckBox cbAi, cbAndroid, cbCyber;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.name);
        etMail = findViewById(R.id.mail);
        radioGroup = findViewById(R.id.radioGroup);
        cbAi = findViewById(R.id.ai);
        cbAndroid = findViewById(R.id.ml);
        cbCyber = findViewById(R.id.cyber);
        btnSave = findViewById(R.id.btn);

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String mail = etMail.getText().toString();

            String category = "";
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                category = selectedRadioButton.getText().toString();
            }

            String interests = "";
            if (cbAi.isChecked()) {
                interests += "AI/ML ";
            }
            if (cbAndroid.isChecked()) {
                interests += "Android ";
            }
            if (cbCyber.isChecked()) {
                interests += "Cybersecurity ";
            }

            SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("NAME", name);
            editor.putString("MAIL", mail);
            editor.putString("CATEGORY", category);
            editor.putString("INTERESTS", interests);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            startActivity(intent);

        });
    }
}
