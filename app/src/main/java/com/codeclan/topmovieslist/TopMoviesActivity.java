package com.codeclan.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TopMoviesActivity extends Mymenu {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_list);
        dbHelper = new DBHelper(this);
        ArrayList<Movie> movieList = Movie.all(dbHelper);

        TopMoviesAdapter movieAdapter = new TopMoviesAdapter(this, movieList);
        ListView listView = (ListView)findViewById(R.id.movie_list);
        listView.setAdapter(movieAdapter);
    }



    public void getMovie(View listItem){
        Movie movie = (Movie) listItem.getTag();
        Intent i = new Intent(this, MovieActivity.class);
        i.putExtra("title", movie.getTitle());
        i.putExtra("rank", movie.getRanking().toString());
        i.putExtra("year", movie.getYear().toString());
        i.putExtra("id", movie.getId());
        startActivity(i);

    }
}
