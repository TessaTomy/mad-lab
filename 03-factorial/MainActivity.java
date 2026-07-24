package com.example.factorial;

import static com.example.factorial.R.*;
import static com.example.factorial.R.id.btn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText n;
    Button btn;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        res= findViewById(R.id.txt);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn)
        {
            n=findViewById(R.id.num);


            int num=Integer.parseInt(String.valueOf(n.getText()));

            int fact=1;
            for(int i=1;i<=num;i++)
                fact*=i;

            res.setText(String.valueOf(fact));
        }
    }
}
