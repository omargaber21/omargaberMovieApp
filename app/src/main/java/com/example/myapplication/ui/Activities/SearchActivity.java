package com.example.myapplication.ui.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.ui.Adapters.MoviesAdapter;
import com.example.myapplication.ui.ViewModels.MoviesViewModel;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class SearchActivity extends AppCompatActivity {
MoviesViewModel moviesViewModel;
RecyclerView recyclerView;
CompositeDisposable compositeDisposable=new CompositeDisposable();
MoviesAdapter.RecyclerViewOnClickListener listener;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView=findViewById(R.id.recyclerview);
         toolbar=findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         if(getSupportActionBar()!=null){
             getSupportActionBar().setTitle("Click on Search icon");
             getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         }
        moviesViewModel =new ViewModelProvider(this).get(MoviesViewModel.class);
         MoviesAdapter moviesAdapter=new MoviesAdapter();
         if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
             recyclerView.setLayoutManager(new GridLayoutManager(this,2));
         }else{
             recyclerView.setLayoutManager(new GridLayoutManager(this,3));
         }

         recyclerView.setAdapter(moviesAdapter);


         moviesViewModel.moviesResponseMutableLiveData.observe(this, new Observer<MoviesResponse>() {
             @Override
             public void onChanged(MoviesResponse moviesResponse) {
                 if(moviesResponse==null){
                     return;
                 }
                 listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                     @Override
                     public void onClick(View view, int position) {
                         Intent intent=new Intent(getApplicationContext(), MovieDetails.class);
                         intent.putExtra("movie_id",moviesResponse.getResults().get(position).getId());
                         startActivity(intent);
                     }
                 };
             moviesAdapter.setList(moviesResponse.getResults());
             moviesAdapter.setListener(listener);
             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_toolbar,menu);
        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.onActionViewExpanded();
        searchView.setQueryHint("Enter Movie Name...");
        menuItem.setActionView(searchView);
        menuItem.expandActionView();
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        emitter.onNext(newText);

                        return true;
                    }
                });
            }
        }).debounce(2, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .filter(f->!f.toString().equals(""))
                .subscribe(new io.reactivex.rxjava3.core.Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                    moviesViewModel.searchMovies(o.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
