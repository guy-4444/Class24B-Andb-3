package com.guy.class24b_andb_3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface MoviesApi {

    @GET("raw/tY5Q7Bv6")
    Call<List<Movie>> loadMovies();

    @GET("raw/{movieKey}")
    Call<Movie> loadMovieByKey(@Path(value = "movieKey", encoded = true) String _movieKey);

    @GET("raw/{movieKey}")
    Call<Movie> loadTheMostViewsMovie();

}
