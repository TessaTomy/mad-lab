package com.example.dynamiclistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ListView list;

    String[] numbers = {"1", "2", "3"};

    int[] images = {
            R.drawable.face,
            R.drawable.face2,
            R.drawable.face3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        list = findViewById(R.id.list);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        numbers);

        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            img.setImageResource(images[position]);
        });
    }
}
