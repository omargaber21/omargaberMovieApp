package com.example.myapplication.data;

import com.example.myapplication.model.MovieDetailsModel;
import com.example.myapplication.model.MovieTrailers;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.NowPlayingMovies;
import com.example.myapplication.model.PersonDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesInterface {
    public static final String API_KEY = "c409e6f8949890aaadf35a51c1a2c9c4";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";
    public final String YT_API_KEY = "AIzaSyDjTShYmFKMKhOtC4BiqnYXQvHpMDdejWc";

    @GET("search/movie")
    public Call<MoviesResponse> getMovies(@Query("api_key") String api_key, @Query("query") String query);

    @GET("movie/{movie_id}/videos")
    public Call<MovieTrailers> getTrailers(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    @GET("movie/now_playing")
    public Call<NowPlayingMovies> getNowPlaying(@Query("api_key") String api_key);

    @GET("movie/popular")
//popular api model same as MoviesResponse Model
    public Call<MoviesResponse> getPopular(@Query("api_key") String api_key);

    @GET("movie/{movie_id}/similar")
    public Call<MoviesResponse> getSimilar(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    @GET("discover/movie")
    public Call<MoviesResponse> getMovieByGenre(@Query("api_key") String api_key, @Query("with_genres") int with_genres);

    @GET("movie/{movie_id}")
    public Call<MovieDetailsModel> getMovieDetails(@Path("movie_id") int movie_id, @Query("api_key") String api_key, @Query("append_to_response") String append_to_response);

    @GET("discover/movie")
    public Call<MoviesResponse> getCastKnownFor(@Query("sort_by") String sort_by, @Query("with_cast") int with_cast, @Query("api_key") String api_key);

    @GET("person/{person_id}")
    public Call<PersonDetails> getPersonDetails(@Path("person_id") int person_id, @Query("api_key") String api_key);
}
