package com.example.lab2;

import static com.example.lab2.DBContract.UserEntry.COLUMN_NAME_KEY_ID;
import static com.example.lab2.DBContract.UserEntry.COLUMN_NAME_LOGIN;
import static com.example.lab2.DBContract.UserEntry.COLUMN_NAME_PASS;
import static com.example.lab2.DBContract.UserEntry.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Users.db";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_NAME_KEY_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_LOGIN + " TEXT," + COLUMN_NAME_PASS + " TEXT" + ")";

        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_LOGIN, user.getLogin());
        values.put(COLUMN_NAME_PASS, user.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_NAME_KEY_ID};
        String selection = COLUMN_NAME_LOGIN + " = ?" + " AND " + COLUMN_NAME_PASS + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

   /* public List<User> getUsers(){
       List<User> users = new ArrayList<>();
       SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_NAME_KEY_ID, COLUMN_NAME_LOGIN, COLUMN_NAME_PASS};
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        while (cursor.moveToNext()) { // проходим по всем записям в курсоре
            int id = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_KEY_ID)); // получаем значение столбца ID из текущей записи
            String username = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_LOGIN)); // получаем значение столбца USERNAME из текущей записи
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_PASS)); // получаем значение столбца PASSWORD из текущей записи
            User user = new User(id, username, password); // создаем объект класса User с полученными значениями
            users.add(user); // добавляем пользователя в список
            cursor.close();
        return users;
    }*/



}
