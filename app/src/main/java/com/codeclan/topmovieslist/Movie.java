package com.codeclan.topmovieslist;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.codeclan.topmovieslist.DBHelper.MOVIES_COLUMN_ID;
import static com.codeclan.topmovieslist.DBHelper.MOVIES_COLUMN_RANK;
import static com.codeclan.topmovieslist.DBHelper.MOVIES_COLUMN_TITLE;
import static com.codeclan.topmovieslist.DBHelper.MOVIES_COLUMN_YEAR;
import static com.codeclan.topmovieslist.DBHelper.MOVIES_TABLE_NAME;
import static com.codeclan.topmovieslist.R.string.rank;

public class Movie {

    private Integer ranking;
    private String title;
    private int year;
    private Integer id;

    public Movie(Integer ranking, String title, Integer year) {
        this.ranking = ranking;
        this.title = title;
        this.year = year;
    }

    public Movie(Integer id, Integer ranking, String title, Integer year){
        this.id = id;
        this.ranking = ranking;
        this.title = title;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public boolean save(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MOVIES_COLUMN_RANK, this.ranking);
        cv.put(MOVIES_COLUMN_TITLE, this.title);
        cv.put(MOVIES_COLUMN_YEAR, this.year);
        db.insert(MOVIES_TABLE_NAME, null, cv);

        return true;
    }

    public static ArrayList<Movie> all(DBHelper dbHelper){
        ArrayList<Movie> movies = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MOVIES_TABLE_NAME, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_ID));
            int rank = cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RANK));
            String title = cursor.getString(cursor.getColumnIndex(MOVIES_COLUMN_TITLE));
            int year = cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_YEAR));
            Movie movie = new Movie(id, rank, title, year);
            movies.add(movie);
        }
        cursor.close();
        return movies;
    }

    public static boolean deleteAll(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + MOVIES_TABLE_NAME);
        return true;
    }

    public static boolean delete(DBHelper dbHelper, Integer id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = " id = ?";
        String[] values = {id.toString()};
        db.delete(MOVIES_TABLE_NAME, selection, values);
        return true;
    }


}
