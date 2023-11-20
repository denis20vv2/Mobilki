package com.example.lab2;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import java.util.Locale;

public class Main_Active extends Activity {
    String currentLanguage;
    String username;
    String password;

    private SharedPreferences sharedPreferences;

  //  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

   /*  @Override
   protected void onStop()  {
        super.onStop();
        // Сохраняем язык интерфейса в SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("language", getResources().getConfiguration().locale.getLanguage());
        editor.apply();
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Main_Active.this, "onResume", Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.editTextText);
        //TextView textView43 = findViewById(R.id.textView43);

        String savedInput = sharedPreferences.getString("text", "");
        textView.setText(savedInput);


        //currentLanguage = sharedPreferences.getString("language", "");
       // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //String language = preferences.getString("language", "");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Main_Active.this, "onPause", Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.editTextText);
        String userInput = textView.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text", userInput);


        editor.putString("language", currentLanguage );

        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        Button button5 = findViewById(R.id.button5);
        TextView password_line = findViewById(R.id.editTextNumberPassword);
        String Text = button.getText().toString();
        String Text3 = button3.getText().toString();
        String Text5 = button5.getText().toString();
        String Text_password = password_line.getHint().toString();
        //editor.apply();
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language1",Text );
        editor.putString("language2",Text3 );
        editor.putString("language3",Text5 );
        editor.putString("language4",Text_password );



        editor.apply();



    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        Button button5 = findViewById(R.id.button5);
        TextView textView = findViewById(R.id.editTextText);
        TextView password_line = findViewById(R.id.editTextNumberPassword);
        //TextView textView43 = findViewById(R.id.textView43);
        sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("language", Context.MODE_PRIVATE);
        currentLanguage = sharedPreferences.getString("language", "");
        //Toast.makeText(Main_Active.this, currentLanguage, Toast.LENGTH_SHORT).show();



// Извлекаем сохраненный текст из SharedPreferences для кнопки btn1
        SharedPreferences sharedPref = getSharedPreferences("language1", Context.MODE_PRIVATE);
        String savedText = sharedPref.getString("language1", "");
        button.setText(savedText);

        //if (currentLanguage.equals("")) currentLanguage = "ru";


        /*if (currentLanguage.equals("ru")) {
            button.setText("Зарегестрироваться");
            button3.setText("Войти");
            password_line.setText("Пароль");
        }

        else if (currentLanguage.equals("en")) {
            button.setText("autorizate");
            button3.setText("log-in");
            password_line.setText("password");

        }*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String language_stock=sharedPreferences.getString("language_s", "NULL");
        //editor.putString("language_s", null );
        if (language_stock.equals("NULL")) {
            //editor.putString("language", "ru" );
            editor.putString("language1","Зарегестрироваться" );
            editor.putString("language2","Войти" );
            editor.putString("language3","ru" );
            editor.putString("language4","пароль" );
        }
        // else {

        String Text1 = sharedPreferences.getString("language1", "");
        button.setText(Text1);
        String Text3 = sharedPreferences.getString("language2", "");
        button3.setText(Text3);
        String Text5 = sharedPreferences.getString("language3", "");
        button5.setText(Text5);
        String Text6 = sharedPreferences.getString("language4", "");
        password_line.setHint(Text6);





       /* if (currentLanguage.equals("ru")) {
            button.setText("Зарегестрироваться");
            button3.setText("Войти");
            password_line.setText("Пароль");
        }

        else if (currentLanguage.equals("eu")) {
            button.setText("autorizate");
            button3.setText("log-in");
            password_line.setText("password");

        }*/

        // sharedPreferences = getSharedPreferences("currentLanguage", Context.MODE_PRIVATE);
        // Получаем язык интерфейса из SharedPreferences


       /* if (currentLanguage.equals(" ")) currentLanguage = "en";
        Locale locale = new Locale(currentLanguage);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration(getResources().getConfiguration());
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        Toast.makeText(Main_Active.this, currentLanguage, Toast.LENGTH_SHORT).show();
        /*Intent intent = getIntent();
        finish();
        startActivity(intent);*/


        button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (currentLanguage.equals("ru")) {

                        currentLanguage = "en";
                        button3.setText("login");
                        button.setText("Autorizate");
                        button5.setText("en");
                        password_line.setHint("password");
                        textView.setHint("login");
                        /*Locale locale = new Locale(currentLanguage);
                        Locale.setDefault(locale);
                        Configuration configuration = new Configuration(getResources().getConfiguration());
                        configuration.setLocale(locale);
                        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
                        Toast.makeText(Main_Active.this, currentLanguage, Toast.LENGTH_SHORT).show();*/

                    } else {

                        currentLanguage = "ru";
                        button3.setText("войти");
                        button.setText("регистрация");
                        button5.setText("ru");
                        password_line.setHint("пароль");
                        textView.setHint("логин");
                        /*Locale locale = new Locale(currentLanguage);
                        Locale.setDefault(locale);
                        Configuration configuration = new Configuration(getResources().getConfiguration());
                        configuration.setLocale(locale);
                        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
                        Toast.makeText(Main_Active.this, currentLanguage, Toast.LENGTH_SHORT).show();*/
                    }

                   /* if (currentLanguage.equals("ru")) {
                        currentLanguage = "en";
                    }
                    else if (currentLanguage.equals("eu")) {
                        currentLanguage = "ru";
                    }*/


                    // Restart the activity or fragment
                    /*Intent intent = getIntent();
                    finish();
                    startActivity(intent);*/


                    // Перезапустить активность или фрагмент
                   /* Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                   // textView43.setText(currentLanguage);*/
                }
            });


            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    username = textView.getText().toString();
                    password = password_line.getText().toString();


                    if (username.equals("admin1") && password.equals("123456")) {
                        Intent intent = new Intent(Main_Active.this, View_active.class);
                        intent.putExtra("dataKey", username);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Main_Active.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                        //finish();
                    }

                }

            });
        }
    }


