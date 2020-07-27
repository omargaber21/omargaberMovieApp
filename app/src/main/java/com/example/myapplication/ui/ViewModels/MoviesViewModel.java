package com.example.myapplication.ui.ViewModels;

import android.util.Log;

import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.NowPlayingMovies;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoviesViewModel extends ViewModel {
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    private static final String TAG = "MoviesViewModel";
    public MutableLiveData<MoviesResponse> moviesResponseMutableLiveData=new MutableLiveData<>();
    public void searchMovies(String movieName){
        Observable<MoviesResponse> observable= MoviesClient.getInstance().searchMovies(movieName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(n->moviesResponseMutableLiveData.setValue(n),
                e-> Log.d(TAG, "SearchMovies: "+e)
        ));

    }
    public MutableLiveData<NowPlayingMovies> nowPlayingMutableLiveData = new MutableLiveData<>();
    public void getNowPlaying(){
        Observable<NowPlayingMovies> observable=MoviesClient.getInstance().getNowPlaying()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(n->nowPlayingMutableLiveData.setValue(n),
                e-> Log.d(TAG, "GetNowPlaying: "+e)));
    }
    public MutableLiveData<MoviesResponse> popularMutableLiveData = new MutableLiveData<>();
    public void getPopular(){
        Observable<MoviesResponse> observable=MoviesClient.getInstance().getPopular()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(n->popularMutableLiveData.setValue(n),
                e-> Log.d(TAG, "getPopular: "+e)));

    }
    public MutableLiveData<MoviesResponse> moviesByGenreMutableLiveData=new MutableLiveData<>();
    public void getMovieByGenre(int i){
        Observable<MoviesResponse> observable=MoviesClient.getInstance().getMovieByGenre(i)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(n->moviesByGenreMutableLiveData.setValue(n),
                e-> Log.d(TAG, "getMovieByGenre: "+e)));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
