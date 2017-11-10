package com.codeclan.topmovieslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 07/11/2017.
 */

public class TopMoviesAdapter extends ArrayAdapter<Movie> {

    public TopMoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, 0, movies);
    }

    public View getView(int position, View listItemView, ViewGroup parent){
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }
        Movie currentMovie = getItem(position);
        TextView ranking = (TextView)listItemView.findViewById(R.id.rank_view);
        ranking.setText(currentMovie.getRanking().toString());
        TextView title = (TextView)listItemView.findViewById(R.id.title_view);
        title.setText(currentMovie.getTitle());
        TextView year = (TextView)listItemView.findViewById(R.id.year_text);
        year.setText(currentMovie.getYear().toString());

        listItemView.setTag(currentMovie);

        return listItemView;
    }



}
