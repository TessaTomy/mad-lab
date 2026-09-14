package com.example.customresourse;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.face, R.drawable.face2, R.drawable.face3};
    String[] names = {"Face", "Face 2", "Face 3"};

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);

        list.setAdapter(new ArrayAdapter<String>(
                this, R.layout.face_row, R.id.name, names) {

            public View getView(int i, View v, ViewGroup p) {
                v = super.getView(i, v, p);
                ((ImageView) v.findViewById(R.id.image))
                        .setImageResource(images[i]);
                return v;
            }
        });
    }
}
