package com.example.myapplication.ui;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MovieDetailsModel;
import com.example.myapplication.model.MovieTrailers;
import com.example.myapplication.model.MoviesResponse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsViewModel extends ViewModel {
    MutableLiveData<MovieTrailers> movieTrailersMutableLiveData=new MutableLiveData<>();
    public void getTrailers(int movieId){
        MoviesClient.getInstance().getTrailers(movieId).enqueue(new Callback<MovieTrailers>() {
            @Override
            public void onResponse(Call<MovieTrailers> call, Response<MovieTrailers> response) {
                movieTrailersMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieTrailers> call, Throwable t) {

            }
        });
    }
    MutableLiveData<MoviesResponse> movieSimilarMutableLiveData =new MutableLiveData<>();
    public void getSimilar(int movieId){
        MoviesClient.getInstance().getSimilar(movieId).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                movieSimilarMutableLiveData.setValue(response.body());

            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }
    MutableLiveData<MovieDetailsModel> movieDetailsMutableLiveData =new MutableLiveData<>();
    public void getMovieDetails(int movieId){
        MoviesClient.getInstance().getMovieDetails(movieId).enqueue(new Callback<MovieDetailsModel>() {
            @Override
            public void onResponse(Call<MovieDetailsModel> call, Response<MovieDetailsModel> response) {
                movieDetailsMutableLiveData.setValue(response.body());
                System.out.println("wqe");
            }

            @Override
            public void onFailure(Call<MovieDetailsModel> call, Throwable t) {
                System.out.println("wqe"+t);

            }
        });
    }
}
