package com.example.myapplication.ui.ViewModels;

import android.util.Log;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MovieDetailsModel;
import com.example.myapplication.model.MovieTrailers;
import com.example.myapplication.model.MoviesResponse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MovieDetailsViewModel extends ViewModel {
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    public MutableLiveData<MovieTrailers> movieTrailersMutableLiveData=new MutableLiveData<>();
    public void getTrailers(int movieId){
        io.reactivex.rxjava3.core.Observable<MovieTrailers> observable=MoviesClient.getInstance().getTrailers(movieId)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(d->movieTrailersMutableLiveData.setValue(d),
                e-> Log.d(TAG, "GetTrailers: "+e)));
    }
    public MutableLiveData<MoviesResponse> movieSimilarMutableLiveData =new MutableLiveData<>();
    public void getSimilar(int movieId){
        io.reactivex.rxjava3.core.Observable<MoviesResponse> observable=MoviesClient.getInstance().getSimilar(movieId)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(d->movieSimilarMutableLiveData.setValue(d),
                e-> Log.d(TAG, "Similar Movies: "+e)));
    }
    public MutableLiveData<MovieDetailsModel> movieDetailsMutableLiveData =new MutableLiveData<>();
    public void getMovieDetails(int movieId){
        Observable<MovieDetailsModel> observable=MoviesClient.getInstance().getMovieDetails(movieId)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(d->movieDetailsMutableLiveData.setValue(d),
                e-> Log.d(TAG, "GetDetails: "+e)));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
