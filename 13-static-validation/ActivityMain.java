package com.example.pg_13;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText percent = findViewById(R.id.percent);
        CheckBox cb = findViewById(R.id.cb);
        ToggleButton tb = findViewById(R.id.tb);


        percent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int val = Integer.parseInt(s.toString());
                    if (val > 100) {
                        percent.setText("100");
                        percent.setSelection(3);
                    }
                } catch (Exception ignored) {}
            }
        });


        cb.setOnClickListener(v ->
                Toast.makeText(this, "Checked: " + cb.isChecked(), Toast.LENGTH_SHORT).show()
        );


        tb.setOnCheckedChangeListener((buttonView, isChecked) ->
                tb.setBackgroundColor(isChecked ? Color.YELLOW : Color.GRAY)
        );
    }
}
