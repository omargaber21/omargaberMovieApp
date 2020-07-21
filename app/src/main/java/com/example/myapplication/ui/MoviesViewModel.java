package com.example.myapplication.ui;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.NowPlayingMovies;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {
    MutableLiveData<MoviesResponse> moviesResponseMutableLiveData=new MutableLiveData<>();
    public void getMovies(String movieName){

        MoviesClient.getInstance().getMovies(movieName).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
            moviesResponseMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                System.out.println("OnResponse Fail"+t);
            }
        });
    }
    MutableLiveData<NowPlayingMovies> nowPlayingMutableLiveData = new MutableLiveData<>();
    public void getNowPlaying(){
        MoviesClient.getInstance().getNowPlaying().enqueue(new Callback<NowPlayingMovies>() {
            @Override
            public void onResponse(Call<NowPlayingMovies> call, Response<NowPlayingMovies> response) {
                nowPlayingMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NowPlayingMovies> call, Throwable t) {
                System.out.println("Fail "+t);

            }
        });
    }
    MutableLiveData<MoviesResponse> popularMutableLiveData = new MutableLiveData<>();
    public void getPopular(){
        MoviesClient.getInstance().getPopular().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                popularMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }
    MutableLiveData<MoviesResponse> moviesByGenreMutableLiveData=new MutableLiveData<>();
    public void getMovieByGenre(int i){
        MoviesClient.getInstance().getMovieByGenre(i).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                moviesByGenreMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }

}
