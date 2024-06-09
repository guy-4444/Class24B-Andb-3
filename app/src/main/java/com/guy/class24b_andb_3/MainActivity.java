package com.guy.class24b_andb_3;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new MoviesController().fetchAllMovies(new MoviesController.CallBack_Movies() {
            @Override
            public void ready(List<Movie> movies) {
                refreshUI(movies);
            }

            @Override
            public void ready(Movie movie) {

            }
        });

        new MoviesController().fetchMovieById("uWcaqqs9", new MoviesController.CallBack_Movies() {
            @Override
            public void ready(List<Movie> movies) {

            }

            @Override
            public void ready(Movie movie) {
                movie(movie);
            }
        });



        new GenericController(new GenericController.CallBack_Generic() {
            @Override
            public void success(String data) {
                electionsData(data);
            }

            @Override
            public void error(String error) {

            }
        }).fetchData("https://pastebin.com/raw/h3BA1qh5");
    }


    private void electionsData(String data) {
        Toast.makeText(this, "electionsData: " + data.length(), Toast.LENGTH_SHORT).show();
    }

    private void movie(Movie movie) {
        Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void refreshUI(List<Movie> movies) {
        Log.d("pttt", movies.size() + " movies updated");
        // notify RecyclerView
    }


}