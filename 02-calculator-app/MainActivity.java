package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText n1, n2;
    private Button add, sub, mul, div;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        res = findViewById(R.id.res);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);


        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int num1 = 0;
        int num2 = 0;

        try {

            num1 = Integer.parseInt(n1.getText().toString());
            num2 = Integer.parseInt(n2.getText().toString());
        } catch (NumberFormatException e) {
            res.setText("Enter valid integer values !!!");
            return;
        }

        int id = v.getId();


        if (id == R.id.add) {
            res.setText(String.valueOf(num1 + num2));
        } else if (id == R.id.sub) {
            res.setText(String.valueOf(num1 - num2));
        } else if (id == R.id.mul) {
            res.setText(String.valueOf(num1 * num2));
        } else if (id == R.id.div) {

            if (num2 == 0) {
                res.setText("Cannot divide by zero!");
            } else {

                res.setText(String.valueOf((double) num1 / num2));
            }
        }
    }
}
