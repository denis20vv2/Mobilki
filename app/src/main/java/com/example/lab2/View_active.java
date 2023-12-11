package com.example.lab2;


//import static android.content.ContentValues.TAG;
import static java.lang.Thread.sleep;

import android.app.Activity;
//import android.app.User;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class View_active extends Activity {
    boolean cancelFlag = false; // Флаг для отмены вывода
    private final static String TAG = "MainActivity";
    String selectedItem;
    String text;
    String dataName;
    String pasName;

    Integer count = 0;
    Cursor usersCursor;

    DatabaseHandler databaseHelper;
    SimpleCursorAdapter userAdapter;

    //SQLiteDatabase db_sort;

    ArrayList<String> user = new ArrayList<>();
    List<User> users = new ArrayList<>();

    private DatabaseHandler dbHandler;
    DatabaseHandler db = new DatabaseHandler(this);

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

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(View_active.this, "onPause", Toast.LENGTH_SHORT).show();
    }

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
        pasName = getIntent().getStringExtra("pasKey");
        ListView listView = findViewById(R.id.listView);
        EditText editTextText3 = findViewById(R.id.editTextText3);
        Button button4 = findViewById(R.id.button4);
        Button button2 = findViewById(R.id.button2);
        Button button5 = findViewById(R.id.button5);

        // Создание экземпляра класса-помощника для работы с базой данных
        DatabaseHandler db = new DatabaseHandler(this);

        users = db.getAllUsers();
        for(User user1: users){
            user.add(user1.getLogin());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, user);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        db.deleteUser(dataName, pasName);
                        //Toast.makeText(getApplicationContext(), "Пользователь удален", Toast.LENGTH_SHORT).show();
                        yourActivityReference.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Пользователь удален", Toast.LENGTH_SHORT).show();
                    }
                }).start();
               /* user.remove(selectedItem);
                listView.clearChoices();
                adapter.notifyDataSetChanged();*/
                //Toast.makeText(getApplicationContext(), "Пользователь удален", Toast.LENGTH_SHORT).show();
            }
        });
       }
    }

