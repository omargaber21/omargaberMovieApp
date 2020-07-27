package com.example.myapplication.data;

import com.example.myapplication.model.MovieDetailsModel;
import com.example.myapplication.model.MovieTrailers;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.NowPlayingMovies;
import com.example.myapplication.model.PersonDetails;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesInterface {
    public static final String API_KEY = "c409e6f8949890aaadf35a51c1a2c9c4";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";
    public final String YT_API_KEY = "AIzaSyDjTShYmFKMKhOtC4BiqnYXQvHpMDdejWc";

    @GET("search/movie")
    public Observable<MoviesResponse> searchMovies(@Query("api_key") String api_key, @Query("query") String query);

    @GET("movie/{movie_id}/videos")
    public Observable<MovieTrailers> getTrailers(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    @GET("movie/now_playing")
    public Observable<NowPlayingMovies> getNowPlaying(@Query("api_key") String api_key);

    @GET("movie/popular")
//popular api model same as MoviesResponse Model
    public Observable<MoviesResponse> getPopular(@Query("api_key") String api_key);

    @GET("movie/{movie_id}/similar")
    public Observable<MoviesResponse> getSimilar(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    @GET("discover/movie")
    public Observable<MoviesResponse> getMovieByGenre(@Query("api_key") String api_key, @Query("with_genres") int with_genres);

    @GET("movie/{movie_id}")
    public Observable<MovieDetailsModel> getMovieDetails(@Path("movie_id") int movie_id, @Query("api_key") String api_key, @Query("append_to_response") String append_to_response);

    @GET("discover/movie")
    public Observable<MoviesResponse> getCastKnownFor(@Query("sort_by") String sort_by, @Query("with_cast") int with_cast, @Query("api_key") String api_key);

    @GET("person/{person_id}")
    public Observable<PersonDetails> getPersonDetails(@Path("person_id") int person_id, @Query("api_key") String api_key);
}
