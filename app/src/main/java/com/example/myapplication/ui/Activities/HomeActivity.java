package com.example.myapplication.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.NowPlayingMovies;
import com.example.myapplication.ui.Adapters.MoviesAdapter;
import com.example.myapplication.ui.ViewModels.MoviesViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.marozzi.segmentedtab.SegmentedGroup;
import com.marozzi.segmentedtab.SegmentedTab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
RecyclerView mostPopular,nowPlaying,moviesByGenre;
MoviesAdapter.RecyclerViewOnClickListener listener;
MoviesViewModel moviesViewModel;
Toolbar toolbar;
SegmentedGroup segmentedGroup;
    MoviesAdapter mostPopularAdapter;
    MoviesAdapter nowPlayingAdapter;
    MoviesAdapter moviesByGenreAdapter;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("MoviesApp");
        setSupportActionBar(toolbar);
        mostPopular=findViewById(R.id.recyclerViewPopular);
        nowPlaying=findViewById(R.id.recyclerViewNowPlaying);
        moviesByGenre=findViewById(R.id.recyclerMovieByGenre);
        segmentedGroup=findViewById(R.id.group_one);
        mostPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        nowPlaying.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        moviesByGenre.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mostPopularAdapter=new MoviesAdapter();
        nowPlayingAdapter=new MoviesAdapter();
        moviesByGenreAdapter=new MoviesAdapter();
        mostPopular.setAdapter(mostPopularAdapter);
        nowPlaying.setAdapter(nowPlayingAdapter);
        moviesByGenre.setAdapter(moviesByGenreAdapter);
        moviesViewModel=new ViewModelProvider(this).get(MoviesViewModel.class);
        moviesViewModel.getNowPlaying();
        moviesViewModel.getPopular();
        mAuth=FirebaseAuth.getInstance();

        //show Action movies at Home, untill user change it
        moviesViewModel.getMovieByGenre(14);
        getMoviesByGenre();
        moviesViewModel.nowPlayingMutableLiveData.observe(this, new Observer<NowPlayingMovies>() {
            @Override
            public void onChanged(NowPlayingMovies moviesResponseResults) {
                nowPlayingAdapter.setList(moviesResponseResults.getResults());
                listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent=new Intent(getApplicationContext(), MovieDetails.class);
                        intent.putExtra("movie_id",moviesResponseResults.getResults().get(position).getId());
                        startActivity(intent);
                    }
                };
                nowPlayingAdapter.setListener(listener);
            }
        });
        moviesViewModel.popularMutableLiveData.observe(this, new Observer<MoviesResponse>() {
            @Override
            public void onChanged(MoviesResponse moviesResponse) {
                mostPopularAdapter.setList(moviesResponse.getResults());
                listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent=new Intent(getApplicationContext(), MovieDetails.class);
                        intent.putExtra("movie_id",moviesResponse.getResults().get(position).getId());
                        startActivity(intent);
                    }
                };
                mostPopularAdapter.setListener(listener);
            }
        });
        moviesViewModel.moviesByGenreMutableLiveData.observe(this, new Observer<MoviesResponse>() {
            @Override
            public void onChanged(MoviesResponse moviesResponse) {

                moviesByGenreAdapter.setList(moviesResponse.getResults());
                listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent=new Intent(getApplicationContext(), MovieDetails.class);
                        intent.putExtra("movie_id",moviesResponse.getResults().get(position).getId());
                        startActivity(intent);
                    }
                };
                moviesByGenreAdapter.setListener(listener);
            }
        });
    }
    private void getMoviesByGenre(){
    segmentedGroup.setOnSegmentedGroupListener(new SegmentedGroup.OnSegmentedGroupListener() {
        @Override
        public void onSegmentedTabSelected(SegmentedTab tab, int checkedId) {
            switch (tab.getId()){
                case R.id.tab_Drama:moviesViewModel.getMovieByGenre(18);
                break;
                case R.id.tab_Action:moviesViewModel.getMovieByGenre(28);
                    break;
                case R.id.tab_Adventure:moviesViewModel.getMovieByGenre(12);
                    break;
                case R.id.tab_Animation:moviesViewModel.getMovieByGenre(16);
                    break;
                case R.id.tab_Comedy:moviesViewModel.getMovieByGenre(35);
                    break;
                case R.id.tab_Crime:moviesViewModel.getMovieByGenre(80);
                    break;
                case R.id.tab_Documentary:moviesViewModel.getMovieByGenre(99);
                    break;
                case R.id.tab_Family:moviesViewModel.getMovieByGenre(10751);
                    break;
                case R.id.tab_Fantasy:moviesViewModel.getMovieByGenre(14);
                    break;
                case R.id.tab_History:moviesViewModel.getMovieByGenre(36);
                    break;
                case R.id.tab_Horror:moviesViewModel.getMovieByGenre(27);
                    break;
                case R.id.tab_Music:moviesViewModel.getMovieByGenre(10402);
                    break;
                case R.id.tab_Mystery:moviesViewModel.getMovieByGenre(9648);
                    break;
                case R.id.tab_Romance:moviesViewModel.getMovieByGenre(10749);
                    break;
                case R.id.tab_Science_Fiction:moviesViewModel.getMovieByGenre(878);
                    break;
                case R.id.tab_TV_Movie:moviesViewModel.getMovieByGenre(10770);
                    break;
                case R.id.tab_Thriller:moviesViewModel.getMovieByGenre(53);
                    break;
                case R.id.tab_War:moviesViewModel.getMovieByGenre(10752);
                    break;
                case R.id.tab_Western:moviesViewModel.getMovieByGenre(37);
                    break;

            }
        }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_bar_search:Intent intent=new Intent(getApplicationContext(), SearchActivity.class);
            getApplicationContext().startActivity(intent);
            break;
            case R.id.app_bar_account:mAuth.signOut();
                Intent intent2=new Intent(getApplicationContext(),LoginScreen.class);
                startActivity(intent2);
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
