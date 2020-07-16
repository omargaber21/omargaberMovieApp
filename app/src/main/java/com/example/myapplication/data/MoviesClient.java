package com.example.myapplication.data;

import com.example.myapplication.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {
    private static final String API_KEY="c409e6f8949890aaadf35a51c1a2c9c4";
    private static final String BASE_URL="https://api.themoviedb.org/3/";
    public final String IMAGE_BASE_URL="https://image.tmdb.org/t/p/w500/";

    private static MoviesClient INSTANCE;
    private MoviesInterface moviesInterface;
    public MoviesClient(){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    moviesInterface=retrofit.create(MoviesInterface.class);
    }
  public static MoviesClient getInstance(){
  if(INSTANCE==null){
   INSTANCE=new MoviesClient();
  }
  return INSTANCE;
  }

   public Call<MoviesResponse> getMovies(String movieName){
       System.out.println("Key is"+API_KEY);
   return moviesInterface.getMovies(API_KEY,movieName);

   }

}
