package com.example.a14_option_menu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_fact) {
            // Step 1: Create the input EditText
            EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);

            // Step 2: Initialize AlertDialog.Builder
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter Number");
            builder.setView(input);

            // Step 3: Set positive button action
            builder.setPositiveButton("Calculate", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        String text = input.getText().toString();
                        int n = Integer.parseInt(text);

                        int fact = 1;
                        for (int i = 1; i <= n; i++) {
                            fact = fact * i;
                        }

                        Toast.makeText(MainActivity.this, "Factorial: " + fact, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Step 4: Set negative button
            builder.setNegativeButton("Cancel", null);

            // Step 5: Build and display dialog
            AlertDialog dialog = builder.create();
            dialog.show();

            return true;
        } else if (id == R.id.menu_male) {
            item.setChecked(true);
            mainLayout.setBackgroundResource(R.drawable.boy);
            return true;
        } else if (id == R.id.menu_female) {
            item.setChecked(true);
            mainLayout.setBackgroundResource(R.drawable.girl);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
