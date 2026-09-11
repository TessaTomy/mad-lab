package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView display;
    double num1 = 0;
    String op = "";

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView6);

        findViewById(R.id.n0).setOnClickListener(v -> display.append("0"));
        findViewById(R.id.n1).setOnClickListener(v -> display.append("1"));
        findViewById(R.id.n2).setOnClickListener(v -> display.append("2"));
        findViewById(R.id.n3).setOnClickListener(v -> display.append("3"));
        findViewById(R.id.n4).setOnClickListener(v -> display.append("4"));
        findViewById(R.id.n5).setOnClickListener(v -> display.append("5"));
        findViewById(R.id.n6).setOnClickListener(v -> display.append("6"));
        findViewById(R.id.n7).setOnClickListener(v -> display.append("7"));
        findViewById(R.id.n8).setOnClickListener(v -> display.append("8"));
        findViewById(R.id.n9).setOnClickListener(v -> display.append("9"));

        findViewById(R.id.add).setOnClickListener(v -> calculate("+"));
        findViewById(R.id.sub).setOnClickListener(v -> calculate("-"));
        findViewById(R.id.mul).setOnClickListener(v -> calculate("*"));
        findViewById(R.id.div).setOnClickListener(v -> calculate("/"));

        findViewById(R.id.eq).setOnClickListener(v -> calculate("="));

        findViewById(R.id.clr).setOnClickListener(v -> {
            display.setText("");
            num1 = 0;
            op = "";
        });
    }

    void calculate(String newOp) {

        if (display.getText().toString().isEmpty())
            return;

        double num2 = Double.parseDouble(display.getText().toString());

        if (op.equals("+"))
            num1 = num1 + num2;
        else if (op.equals("-"))
            num1 = num1 - num2;
        else if (op.equals("*"))
            num1 = num1 * num2;
        else if (op.equals("/"))
            num1 = num1 / num2;
        else
            num1 = num2;

        op = newOp;
        display.setText("");

        if (newOp.equals("="))
            display.setText(String.valueOf(num1));
    }
}
