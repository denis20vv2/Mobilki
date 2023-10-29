package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        TextView textView = findViewById(R.id.editTextText);
        TextView password_line = findViewById(R.id.editTextNumberPassword);


      //  File file = new File("C:\\Users\\denis\\AndroidStudioProjects\\Mobilki\\Mobilki\\app\\src\\main\\res\\datebase.txt");

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textView.getText().toString();
                String password = password_line.getText().toString();

                /*FileWriter writer;
                try {
                    writer = new FileWriter(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // Записываем данные из EditText в файл
                try {
                    writer.append(username);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // Закрываем FileWriter
                try {
                    writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }*/


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

