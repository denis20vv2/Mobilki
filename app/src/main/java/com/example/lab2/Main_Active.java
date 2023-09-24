package com.example.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Main_Active extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        setContentView(R.layout.activity_view);

        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);



        // код пишется в методе onCreate()

// получаем экземпляр элемента ListView
        ListView listView = findViewById(R.id.listView);

// определяем строковый массив

        ArrayList<String> myStringArray = new ArrayList<String>();
// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, myStringArray);

        listView.setAdapter(adapter);




    }
}
