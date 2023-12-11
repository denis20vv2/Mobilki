package com.example.lab2;

import static com.example.lab2.DBContract.UserEntry.COLUMN_NAME_KEY_ID;
import static com.example.lab2.DBContract.UserEntry.COLUMN_NAME_LOGIN;
import static com.example.lab2.DBContract.UserEntry.COLUMN_NAME_PASS;
import static com.example.lab2.DBContract.UserEntry.TABLE_NAME;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

   // public static final String COLUMN_NAME_LOGIN = "Colunm_LV";
    //public static final String COLUMN_NAME_TEXT = "Colunm_TXT";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Users.db";

    private DatabaseHandler db;
    private SQLiteOpenHelper mDB;

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

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM " + DBContract.UserEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setID(Integer.parseInt(cursor.getString(0)));
                user.setLogin(cursor.getString(1));
                user.setPass(cursor.getString(2));
                usersList.add(user);
            } while (cursor.moveToNext());
        }
        return usersList;
    }

    public boolean deleteUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_NAME_LOGIN + " = ?" + " AND " + COLUMN_NAME_PASS + " = ?";
        String[] selectionArgs = {username, password};
        int deletedRows = db.delete(TABLE_NAME, selection, selectionArgs);
       // db.insert(TABLE_NAME, null, null);
        db.close();
        return deletedRows > 0;
    }
    public boolean changePas(String username, String password, String newPassword) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_PASS, newPassword);
        String selection = COLUMN_NAME_LOGIN + " = ?" + " AND " + COLUMN_NAME_PASS + " = ?";
        String[] selectionArgs = {username, password};
        int updatedRows = db.update(TABLE_NAME, values, selection, selectionArgs);
        return updatedRows > 0;

    }

}
