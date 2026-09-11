package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listView);

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        days);

        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {

            TextView textView = (TextView) view;

            Toast.makeText(
                    this,
                    textView.getText().toString(),
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
