package com.example.cadastrologinsenha;

import com.example.cadastrologinsenha.ContactContract.ContactEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    //public static final String TABLE_USERS = "users";
    //public static final String COLUMN_ID = "_id";
    //public static final String COLUMN_USERNAME = "username";
    //public static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + ContactEntry.TABLE_USERS + " (" +
                    ContactEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ContactEntry.COLUMN_USERNAME + " TEXT, " +
                    ContactEntry.COLUMN_PASSWORD + " TEXT);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ContactEntry.TABLE_USERS);
        onCreate(db);
    }
}

