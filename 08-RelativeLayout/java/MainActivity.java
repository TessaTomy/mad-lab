package com.example.pg_08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.namee);
        EditText etMail = findViewById(R.id.editTextText3);
        RadioGroup rgGender = findViewById(R.id.radioGroupGender);
        Button btnConfirm = findViewById(R.id.btn);

        btnConfirm.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String mail = etMail.getText().toString();

            int selectedId = rgGender.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedId);
            String gender = (selectedGender != null) ? selectedGender.getText().toString() : "";

            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("NAME_KEY", name);
            editor.putString("MAIL_KEY", mail);
            editor.putString("GENDER_KEY", gender);
            editor.apply();


            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            startActivity(intent);
        });
    }
}
