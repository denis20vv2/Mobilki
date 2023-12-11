package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Main_Active extends Activity {

    private DatabaseHandler dbHandler;

    Button button;
    Button button3;
    TextView textView ;
    TextView password_line;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        dbHandler = new DatabaseHandler(this);


        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        TextView textView = findViewById(R.id.editTextText);
        TextView password_line = findViewById(R.id.editTextNumberPassword);
        TextView editTextNumberPassword2 = findViewById(R.id.editTextNumberPassword2);
        Button button6 = findViewById(R.id.button6);


      //  File file = new File("C:\\Users\\denis\\AndroidStudioProjects\\Mobilki\\Mobilki\\app\\src\\main\\res\\datebase.txt");

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textView.getText().toString();
                String password = password_line.getText().toString();
                String newPassword = editTextNumberPassword2.getText().toString();

                boolean users = dbHandler.checkUser(username, password);


                 if (users == true) {

                    Intent intent = new Intent(Main_Active.this, View_active.class);
                    intent.putExtra("dataKey",username);
                     intent.putExtra("pasKey",password);
                    startActivity(intent);
                } else {
                    Toast.makeText(Main_Active.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }

        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler h = new Handler();



                new Thread(new Runnable() {


                    @Override
                    public void run() {
                        String username = textView.getText().toString();
                        String password = password_line.getText().toString();
                        String newPassword = editTextNumberPassword2.getText().toString();
                        boolean users = dbHandler.checkUser(username, password);
                        dbHandler.changePas(username, password, newPassword);

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Toast.makeText(Main_Active.this, "Пароль изменён", Toast.LENGTH_SHORT).show();
                            }
                        });
                        //Toast.makeText(Main_Active.this, "Пароль изменён", Toast.LENGTH_SHORT).show();
                    }
                }).start();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Handler h = new Handler();
                //String username = textView.getText().toString();
                //String password = password_line.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String username = textView.getText().toString();
                        String password = password_line.getText().toString();
                        dbHandler.addUser(new User(username, password));

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Toast.makeText(Main_Active.this, "Пользователь создан", Toast.LENGTH_SHORT).show();
                            }
                        });
                        //Toast.makeText(Main_Active.this, "Пользователь создан", Toast.LENGTH_SHORT).show();
                    }
                }).start();




                //Toast.makeText(Main_Active.this, "Пользователь создан", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

