package com.example.maghraby.PopularMovies2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.maghraby.PopularMovies2.Model.MovieModel;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(savedInstanceState == null){

            MovieModel movieModel = getIntent().getParcelableExtra("movieModel");
            DetailsActivityFragment detailsActivityFragment = DetailsActivityFragment.newInstance(movieModel);
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, detailsActivityFragment).commit();

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
