package com.example.myapplication.ui;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.PersonDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDetailsViewModel extends ViewModel {
    MutableLiveData<PersonDetails> personDetailsMutableLiveData=new MutableLiveData<>();
    public void getPersonDetails(int person_id){
        MoviesClient.getInstance().getPersonDetails(person_id).enqueue(new Callback<PersonDetails>() {
            @Override
            public void onResponse(Call<PersonDetails> call, Response<PersonDetails> response) {
                personDetailsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PersonDetails> call, Throwable t) {

            }
        });
    }
    MutableLiveData<MoviesResponse> responseMutableLiveData=new MutableLiveData<>();
    public void getCastKnownFor(int person_id){
        MoviesClient.getInstance().getCastKnownFor(person_id).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                responseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }
}
