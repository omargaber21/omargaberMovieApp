package com.example.myapplication.data;

import com.example.myapplication.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesInterface {
@GET("search/movie")
public Call<MoviesResponse> getMovies(@Query("api_key") String api_key,@Query("query") String query);
}
