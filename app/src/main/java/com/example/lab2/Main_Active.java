package com.example.lab2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main_Active extends Activity {

    private String currentLanguage;
    String username;
    String password;


    private SharedPreferences sharedPreferences;
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Main_Active.this, "onResume", Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.editTextText);

        String savedInput = sharedPreferences.getString("text", "");
        textView.setText(savedInput);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedLanguage = preferences.getString("language", "");

        // Установить сохраненный язык интерфейса в переменную currentLanguage
        currentLanguage = savedLanguage;
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Main_Active.this, "onPause", Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.editTextText);
        String userInput = textView.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text", userInput);
        //editor.apply();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);


        editor.putString("language", currentLanguage);
        editor.apply();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        TextView textView = findViewById(R.id.editTextText);
        TextView password_line = findViewById(R.id.editTextNumberPassword);

        sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);

        /* SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("text", textView.getText().toString());
        editor.apply();

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(sharedPref.getString("text",""));
            }
        });*/
      //  File file = new File("C:\\Users\\denis\\AndroidStudioProjects\\Mobilki\\Mobilki\\app\\src\\main\\res\\datebase.txt");

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = textView.getText().toString();
                password = password_line.getText().toString();




                if (username.equals("admin1") && password.equals("123456")) {
                    Intent intent = new Intent(Main_Active.this, View_active.class);
                    intent.putExtra("dataKey",username);
                    startActivity(intent);
                } else {
                    Toast.makeText(Main_Active.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                    //finish();
                }

            }

        });
    }
}

