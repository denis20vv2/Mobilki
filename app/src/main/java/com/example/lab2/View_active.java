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

        /*

// Получение списка пользователей из базы данных
        List<User> users = db.getAllUsers();

// Создание list view
       // ListView listView = new ListView(this);

// Добавление элементов в list view
        for (User user : users)
            listView.addItem(user.getLogin(), user.getPass());


// Отображение list view на экране
        setContentView(listView);
*/
       /* String[] from = new String[] { DatabaseHandler.COLUMN_NAME_LOGIN, DatabaseHandler.COLUMN_NAME_TEXT };
        int[] to = new int[] { R.id.listView, R.id.editTextText3};
        userAdapter = new SimpleCursorAdapter(this, R.layout.activity_view, usersCursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(userAdapter);

          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = ((TextView) view.findViewById(R.id.editTextText3)).getText().toString();
                Toast.makeText(View_active.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editTextText3.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(View_active.this, "Enter text", Toast.LENGTH_SHORT).show();
                } else {
                    dbHandler.addUser(new User(dataName, pasName));
                    editTextText3.setText("");
                    usersCursor.requery();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelFlag == false) {
                    cancelFlag = true;
                } else {
                    cancelFlag = false;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (cancelFlag == false) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            count++;
                            Log.d(TAG, count.toString());
                        }
                        count = 0;
                        Log.d(TAG, "stop");
                    }
                }).start();
            }
        });*/
       // databaseHelper = new DatabaseHandler(this);
        //usersCursor = databaseHelper.getAllData();

        //String[] from = new String[] { DatabaseHandler.COLUMN_NAME_LOGIN, DatabaseHandler.COLUMN_NAME_TEXT };
        //int[] to = new int[] { R.id.listView, R.id.editTextText3};
        //userAdapter = new SimpleCursorAdapter(this, R.layout.activity_view, usersCursor, from, to);
        //listView.setAdapter(userAdapter);


// Создание адаптера с помощью CursorAdapter

        //db_sort = databaseHelper.open();
        //dbHandler = DatabaseHandler.open();
        // =  dbHandler.rawQuery("select * from "+ DatabaseHandler.DATABASE_NAME, null);
       // ArrayList<User> users = (ArrayList<User>) dbHandler.getUsers(); // крашит здесь!
// определяем строковый массив

        //ArrayList<String> myStringArray = new ArrayList<String>();
// используем адаптер данных
        /*ArrayAdapter<User> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, users);

        listView.setAdapter(adapter);
*/
       // dbHandler.getUsers();


       // adapter.addAll(String.valueOf(users));
       /* for (count = 0; count<2; count ++){
            myStringArray.add(String.valueOf(users.get(count)));
            adapter.notifyDataSetChanged();
        }*/

       /* button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editTextText3.getText().toString();
               // String text_2 = text;
               // listView.add(text);
                //editTextText3.getText().clear();
               // myStringArray.add(dataName);
                users.add(text);
                adapter.notifyDataSetChanged();
                editTextText3.getText().clear();

                }
            });*/


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteUser(dataName, pasName);
               /* user.remove(selectedItem);
                listView.clearChoices();
                adapter.notifyDataSetChanged();*/
                Toast.makeText(getApplicationContext(), "Пользователь удален", Toast.LENGTH_SHORT).show();
            }
        });


////////////////////////////////////////////
// Добавляем обработчик выбора элемента из списка
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ListView listView = (ListView) parent;
                selectedItem = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Выбран элемент: " + selectedItem, Toast.LENGTH_SHORT).show();
                /*button4.setVisibility(View.VISIBLE);
                myStringArray.remove(selectedItem);
                myStringArray.clear();
                adapter.notifyDataSetChanged(); /////////////////////
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
       });*/
       }

    }

