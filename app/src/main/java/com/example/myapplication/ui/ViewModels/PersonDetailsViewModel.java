package com.example.myapplication.ui.ViewModels;

import android.util.Log;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.PersonDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PersonDetailsViewModel extends ViewModel {
    private static final String TAG = "PersonDetailsViewModel";
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    public MutableLiveData<PersonDetails> personDetailsMutableLiveData=new MutableLiveData<>();
    public void getPersonDetails(int person_id){
        Observable<PersonDetails> observable=MoviesClient.getInstance().getPersonDetails(person_id)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(d->personDetailsMutableLiveData.setValue(d),
                e-> Log.d(TAG, "getPersonDetails: "+e)));
    }
    public MutableLiveData<MoviesResponse> responseMutableLiveData=new MutableLiveData<>();
    public void getCastKnownFor(int person_id){
        Observable<MoviesResponse> observable=MoviesClient.getInstance().getCastKnownFor(person_id)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(d->responseMutableLiveData.setValue(d),
                e-> Log.d(TAG, "getCastKnownFor: "+e)));
    }
}
