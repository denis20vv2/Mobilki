package com.example.lab2;


//import static android.content.ContentValues.TAG;
import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class View_active extends Activity {

    private SharedPreferences sharedPreferences;
    String currentLanguage;
    @Override
    public void onPause() {


        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(View_active.this, "onPause", Toast.LENGTH_SHORT).show();
        EditText editTextText3 = findViewById(R.id.editTextText3);
        Button button4 = findViewById(R.id.button4);
        Button button2 = findViewById(R.id.button2);
        Button button6 = findViewById(R.id.button6);
        String userInput = editTextText3.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text", userInput);


        editor.putString("language", currentLanguage);


        String Text = button4.getText().toString();
        String Text3 = button2.getText().toString();
        String Text5 = button6.getText().toString();


        //editor.apply();
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language1", Text);
        editor.putString("language2", Text3);
        editor.putString("language3", Text5);
       // editor.putString("language4", Text6);




        editor.apply();
    }

    boolean cancelFlag = false; // Флаг для отмены вывода
    private final static String TAG = "MainActivity";
    String selectedItem;
    String text;
    String dataName;

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart");
        Toast.makeText(View_active.this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast.makeText(View_active.this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(View_active.this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(View_active.this, "onStop", Toast.LENGTH_SHORT).show();
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(View_active.this, "onPause", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast.makeText(View_active.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        dataName = getIntent().getStringExtra("dataKey");
        ListView listView = findViewById(R.id.listView);
        EditText editTextText3 = findViewById(R.id.editTextText3);
        Button button4 = findViewById(R.id.button4);
        Button button2 = findViewById(R.id.button2);
        Button button6 = findViewById(R.id.button6);

        sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("language", Context.MODE_PRIVATE);
        currentLanguage = sharedPreferences.getString("language", "");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String language_stock=sharedPreferences.getString("language_s", "NULL");
        //editor.putString("language_s", null );
        //if (language_stock.equals("NULL")) {
            //editor.putString("language", "ru" );
            editor.putString("language1","добавить" );
            editor.putString("language2","удалить" );
            editor.putString("language3","добавьте текст" );
            editor.putString("language4","ru" );
        //}
        // else {

      /*  String Text1 = sharedPreferences.getString("language1", "");
        button4.setText(Text1);
        String Text3 = sharedPreferences.getString("language2", "");
        button2.setText(Text3);
        String Text5 = sharedPreferences.getString("text", "");
        editTextText3.setText(Text5);
        String Text6 = sharedPreferences.getString("language4", "");
        button6.setText(Text6);*/

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentLanguage.equals("ru")) {

                    currentLanguage = "en";
                    button2.setText("add");
                    button4.setText("delete");
                    button6.setText("en");
                    editTextText3.setHint("enter text");
                        /*Locale locale = new Locale(currentLanguage);
                        Locale.setDefault(locale);
                        Configuration configuration = new Configuration(getResources().getConfiguration());
                        configuration.setLocale(locale);
                        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
                        Toast.makeText(Main_Active.this, currentLanguage, Toast.LENGTH_SHORT).show();*/

                } else {

                    currentLanguage = "ru";
                    button2.setText("добавить");
                    button4.setText("удалить");
                    button6.setText("ru");
                    editTextText3.setHint("введите текст");
                        /*Locale locale = new Locale(currentLanguage);
                        Locale.setDefault(locale);
                        Configuration configuration = new Configuration(getResources().getConfiguration());
                        configuration.setLocale(locale);
                        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
                        Toast.makeText(Main_Active.this, currentLanguage, Toast.LENGTH_SHORT).show();*/
                }
            }
            });


// определяем строковый массив

        ArrayList<String> myStringArray = new ArrayList<String>();
// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, myStringArray);

        listView.setAdapter(adapter);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editTextText3.getText().toString();
               // String text_2 = text;
               /* listView.add(text);
                editTextText3.getText().clear();*/
                myStringArray.add(dataName);
                myStringArray.add(text);
                adapter.notifyDataSetChanged();
                editTextText3.getText().clear();
                /*long timeMillis = System.currentTimeMillis();
                while(timeMillis+5000>System.currentTimeMillis()){


                }*/




               // Timer timer = new Timer();
                // timer.schedule(new TimerTask() {
               /* new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (editTextText3.getText().toString().isEmpty()) {
                            myStringArray.add(text);
                            adapter.notifyDataSetChanged();
                        }
                       // cancelFlag = false;
                    }
                }, 5000);
*/


             /* button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cancelFlag = true;
                                               }

                                           });
                //editTextText3.getText().clear();*/
                }
            });



////////////////////////////////////////////
// Добавляем обработчик выбора элемента из списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ListView listView = (ListView) parent;
                selectedItem = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Выбран элемент: " + selectedItem, Toast.LENGTH_SHORT).show();
                /*button4.setVisibility(View.VISIBLE);
                myStringArray.remove(selectedItem);
                myStringArray.clear();
                adapter.notifyDataSetChanged();*/
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    myStringArray.remove(selectedItem);
                    adapter.notifyDataSetChanged();
                    listView.clearChoices();
                    Toast.makeText(getApplicationContext(), "Элемент удален", Toast.LENGTH_SHORT).show();
            }
       });
       }



        }