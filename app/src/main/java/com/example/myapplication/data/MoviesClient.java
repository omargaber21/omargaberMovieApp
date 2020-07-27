package com.example.myapplication.data;

import com.example.myapplication.model.MovieDetailsModel;
import com.example.myapplication.model.MovieTrailers;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.NowPlayingMovies;
import com.example.myapplication.model.PersonDetails;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {


    private static MoviesClient INSTANCE;
    private MoviesInterface moviesInterface;
    public MoviesClient(){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(moviesInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();
    moviesInterface=retrofit.create(MoviesInterface.class);
    }
  public static MoviesClient getInstance(){
  if(INSTANCE==null){
   INSTANCE=new MoviesClient();
  }
  return INSTANCE;
  }

    public Observable<MoviesResponse> searchMovies(String movieName){
        return moviesInterface.searchMovies(moviesInterface.API_KEY,movieName);

    }

    public Observable<MovieTrailers> getTrailers(int movieId){
        return moviesInterface.getTrailers(movieId,moviesInterface.API_KEY);
    }
    public Observable<NowPlayingMovies> getNowPlaying(){
        return moviesInterface.getNowPlaying(moviesInterface.API_KEY);
    }
    public Observable<MoviesResponse> getPopular(){
        return moviesInterface.getPopular(moviesInterface.API_KEY);
    }
    public Observable<MoviesResponse> getSimilar(int movieId){
        return moviesInterface.getSimilar(movieId,moviesInterface.API_KEY);
    }
    public Observable<MoviesResponse> getMovieByGenre(int genre){
        return moviesInterface.getMovieByGenre(moviesInterface.API_KEY,genre);
    }
    public Observable<MovieDetailsModel> getMovieDetails(int movie_id){
        return moviesInterface.getMovieDetails(movie_id,moviesInterface.API_KEY,"credits");
    }
    public Observable<MoviesResponse> getCastKnownFor(int cast_id){
        return moviesInterface.getCastKnownFor("popularity.desc",cast_id,moviesInterface.API_KEY);
    }
    public Observable<PersonDetails> getPersonDetails(int person_id){
        return moviesInterface.getPersonDetails(person_id,moviesInterface.API_KEY);
    }
}
