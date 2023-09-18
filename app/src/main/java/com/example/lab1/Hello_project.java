package com.example.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Hello_project extends Activity {

    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        TextView TextView = findViewById(R.id.textView);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                TextView.setText(String.valueOf(count));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                TextView.setText(String.valueOf(count));

            }
        });
    }
}


