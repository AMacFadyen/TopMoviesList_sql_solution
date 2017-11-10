package com.codeclan.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddMovieActivity extends AppCompatActivity {

    EditText rankText;
    EditText titleText;
    EditText yearText;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        rankText = (EditText)findViewById(R.id.editRank);
        titleText = (EditText)findViewById(R.id.editTitle);
        yearText = (EditText)findViewById(R.id.editYear);
    }

    public void addMovie(View button){
        dbHelper = new DBHelper(this);
        String title = titleText.getText().toString();
        Integer rank = Integer.parseInt(rankText.getText().toString());
        Integer year = Integer.parseInt(yearText.getText().toString());
        Movie movie = new Movie(rank, title, year);
        movie.save(dbHelper);
        Intent intent = new Intent(this, TopMoviesActivity.class);
        startActivity(intent);
    }
}
