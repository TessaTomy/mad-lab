package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText user,pass;
    Button login;
    String u="sample",p="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        login=(Button) findViewById(R.id.btn);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn)
        {
            user=(EditText) findViewById(R.id.name);
            pass=(EditText) findViewById(R.id.pass);
            String a=user.getText().toString();
            String b=pass.getText().toString();
            if(a.equals(u)&&b.equals(p))
            {
                Toast.makeText(this,"Sucessfull",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
        }
    }
}
