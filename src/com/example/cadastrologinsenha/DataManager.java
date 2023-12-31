package com.example.cadastrologinsenha;

import com.example.cadastrologinsenha.ContactContract.ContactEntry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataManager {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DataManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long cadastrarUsuario(String username, String password) {
        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_USERNAME, username);
        values.put(ContactEntry.COLUMN_PASSWORD, password);

        return database.insert(ContactEntry.TABLE_USERS, null, values);
    }

    public boolean autenticarUsuario(String username, String password) {
        String[] columns = {ContactEntry.COLUMN_USERNAME, ContactEntry.COLUMN_PASSWORD};
        String selection = ContactEntry.COLUMN_USERNAME + " = ? AND " + ContactEntry.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = database.query(ContactEntry.TABLE_USERS, columns, selection, selectionArgs, null, null, null);

        boolean authenticated = cursor.getCount() > 0;

        cursor.close();

        return authenticated;
    }
}
