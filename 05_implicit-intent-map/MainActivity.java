package com.example.map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnOpenMap = findViewById(R.id.btnOpenMap);
        Button btnSendEmail = findViewById(R.id.btnSendEmail);
        Button btnSendMessage = findViewById(R.id.btnSendMessage);
        Button btnOpenPlayStore = findViewById(R.id.btnOpenWeb);

        btnOpenMap.setOnClickListener(this);
        btnSendEmail.setOnClickListener(this);
        btnSendMessage.setOnClickListener(this);
        btnOpenPlayStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btnOpenMap) {
            Uri mapUri = Uri.parse("geo:0,0?q=MACE");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            Intent chooser = Intent.createChooser(mapIntent, "Open Map Using:");
            startActivity(chooser);

        } else if (id == R.id.btnSendEmail) {
            Uri emailUri = Uri.parse("mailto:example@email.com");
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, emailUri);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello from Android App");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "This is the body of the email.");
            Intent emailChooser = Intent.createChooser(emailIntent, "Send Email Using:");
            startActivity(emailChooser);

        } else if (id == R.id.btnSendMessage) {
            Uri smsUri = Uri.parse("smsto:1234567890");
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, smsUri);
            smsIntent.putExtra("sms_body", "Hello! This is an automated text message.");
            Intent smsChooser = Intent.createChooser(smsIntent, "Send Message Using:");
            startActivity(smsChooser);

        } else if (id == R.id.btnOpenWeb) {
        Uri webUri = Uri.parse("https://developer.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(webIntent);
    }
    }
}
