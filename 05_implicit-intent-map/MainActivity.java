package com.example.map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnOpenMap = findViewById(R.id.btnOpenMap);
        btnOpenMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnOpenMap) {
            Uri mapUri = Uri.parse("geo:0,0?q=MACE");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);

            Intent chooser = Intent.createChooser(mapIntent, "Open Map Using:");
            startActivity(chooser);
        }
    }
}
