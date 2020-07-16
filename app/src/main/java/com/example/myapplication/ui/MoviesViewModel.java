package com.example.myapplication.ui;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;

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
            System.out.println("OnResponse Succ");
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                System.out.println("OnResponse Fail"+t);
            }
        });
    }
}
