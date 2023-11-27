package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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


      //  File file = new File("C:\\Users\\denis\\AndroidStudioProjects\\Mobilki\\Mobilki\\app\\src\\main\\res\\datebase.txt");

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textView.getText().toString();
                String password = password_line.getText().toString();

                boolean users = dbHandler.checkUser(username, password);


                 if (users == true) {

                    Intent intent = new Intent(Main_Active.this, View_active.class);
                    intent.putExtra("dataKey",username);
                    startActivity(intent);
                } else {
                    Toast.makeText(Main_Active.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }


                /*if (username.equals("admin1") && password.equals("123456")) {

                    Intent intent = new Intent(Main_Active.this, View_active.class);
                    intent.putExtra("dataKey",username);
                    startActivity(intent);
                } else {
                    Toast.makeText(Main_Active.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }*/



            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textView.getText().toString();
                String password = password_line.getText().toString();
                dbHandler.addUser(new User(username, password));
            }


        });
    }



    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                db.addUser(new User(textView.getText().toString(), password_line.getText().toString()));
                break;
            case R.id.button3:
                List<User> users = db.getAllUsers();
                for (User usr : users) {
                    String log = "Id: "+usr.getID()+" ,Login: " + usr.getLogin() + " ,Password: " + usr.getPass();
                    Log.v("Loading...", log);
                }
                break;
            default:
                break;
        }
    }*/
}

