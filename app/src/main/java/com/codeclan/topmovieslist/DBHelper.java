package com.codeclan.topmovieslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by allymcgilloway on 08/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "movies.db";
    public static final String MOVIES_TABLE_NAME = "movies";
    public static final String MOVIES_COLUMN_ID = "id";
    public static final String MOVIES_COLUMN_RANK = "rank";
    public static final String MOVIES_COLUMN_TITLE = "title";
    public static final String MOVIES_COLUMN_YEAR = "year";
    private HashMap hp;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + MOVIES_TABLE_NAME + "(id INTEGER primary key autoincrement, rank INTEGER, title TEXT, year INTEGER )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + MOVIES_TABLE_NAME);
        onCreate(db);
    }


}
