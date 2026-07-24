package com.example.nav_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        String savedName = sp.getString("name", "");
        String savedMail = sp.getString("mail", "");

        name.setText(savedName);
        mail.setText(savedMail);
    }

    @Override
    public void onClick(View view) {
        String userName = name.getText().toString();
        String userMail = mail.getText().toString();
        SharedPreferences sp = getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", userName);
        editor.putString("mail", userMail);
        editor.apply();

        // 3. Move to Page 2
        Intent intent = new Intent(this, nav_2.class);
        startActivity(intent);

    }
}