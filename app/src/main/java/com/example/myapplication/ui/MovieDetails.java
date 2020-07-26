package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.MoviesInterface;
import com.example.myapplication.model.MovieDetailsModel;
import com.example.myapplication.model.MovieTrailers;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.MoviesResponseResults;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDetails extends AppCompatActivity {
    TextView overviewTV,genresTV,movieNameTV,dateTV,tagLineTV,directorNameTV;
    FloatingActionButton trailerButton;
    ImageView posterImageView;
    ImageView backgroundImage;
    MovieDetailsViewModel movieDetailsViewModel;
    int position;
    RecyclerView similarRecyclerView,castRecyclerView;
    CastAdapter castAdapter;
    MoviesAdapter similarMoviesAdapter;
    MoviesResponseResults results;
    MoviesAdapter.RecyclerViewOnClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        { this.getSupportActionBar().hide();}
        catch (NullPointerException e){}
        setContentView(R.layout.activity_movie_details);
        directorNameTV=findViewById(R.id.textViewDirectorName);
        posterImageView=findViewById(R.id.insideposterImageView);
        similarRecyclerView=findViewById(R.id.recyclerViewSimilar);
        movieNameTV=findViewById(R.id.movieNameTV);
        backgroundImage=findViewById(R.id.backgroundIMG);
        tagLineTV=findViewById(R.id.textViewTagLine);
        castRecyclerView=findViewById(R.id.recyclerViewCast);
        genresTV=findViewById(R.id.genresTV);
        dateTV=findViewById(R.id.textViewDate);
        trailerButton=findViewById(R.id.floatingActionButton);
        overviewTV=findViewById(R.id.overview);
        similarRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        castRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        similarMoviesAdapter=new MoviesAdapter();
        castAdapter=new CastAdapter();
        movieDetailsViewModel =new ViewModelProvider(this).get(MovieDetailsViewModel.class);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            int movie_id=extras.getInt("movie_id");
            movieDetailsViewModel.getMovieDetails(movie_id);
            movieDetailsViewModel.getSimilar(movie_id);
        }
        movieDetailsViewModel.movieTrailersMutableLiveData.observe(this, new Observer<MovieTrailers>() {
            @Override
            public void onChanged(MovieTrailers movieTrailers) {
                trailerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MovieDetails.this,MovieTrailerActivity.class);
                        intent.putExtra("movieTrailers",movieTrailers);
                        startActivity(intent);
                    }
                });
            }
        });
        movieDetailsViewModel.movieSimilarMutableLiveData.observe(this, new Observer<MoviesResponse>() {
            @Override
            public void onChanged(MoviesResponse moviesResponse) {
                similarMoviesAdapter.setList(moviesResponse.getResults());
                similarRecyclerView.setAdapter(similarMoviesAdapter);
                listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        results=moviesResponse.getResults().get(position);
                        Intent intent=new Intent(getApplicationContext(), MovieDetails.class);
                        intent.putExtra("movie_id",results.getId());
                        startActivity(intent);
                    }
                };
                similarMoviesAdapter.setListener(listener);
            }
        });
        movieDetailsViewModel.movieDetailsMutableLiveData.observe(this, new Observer<MovieDetailsModel>() {
            @Override
            public void onChanged(MovieDetailsModel movieDetailsModel) {
                String movieName= movieDetailsModel.getTitle();
                castAdapter.setCastBeanList(movieDetailsModel.getCredits().getCast());
                listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent=new Intent(getApplicationContext(), PersonActivity.class);
                        intent.putExtra("person_id",movieDetailsModel.getCredits().getCast().get(position).getId());
                        startActivity(intent);
                    }
                };
                castAdapter.setListener(listener);
                castRecyclerView.setAdapter(castAdapter);
                movieNameTV.setText(movieName);
                for(MovieDetailsModel.CreditsBean.CrewBean cast: movieDetailsModel.getCredits().getCrew()){
                    if (cast.getJob().equals("Director")){
                        directorNameTV.setText(cast.getName());
                    }
                }
                overviewTV.setText(movieDetailsModel.getOverview());
                movieDetailsViewModel.getTrailers(movieDetailsModel.getId());
                dateTV.setText(movieDetailsModel.getRelease_date());
                tagLineTV.setText(movieDetailsModel.getTagline());
                String backgroundimageUrl= MoviesInterface.IMAGE_BASE_URL+ movieDetailsModel.getBackdrop_path();
                String posterimageUrl= MoviesInterface.IMAGE_BASE_URL+ movieDetailsModel.getPoster_path();
                if(movieDetailsModel.getBackdrop_path()!=null){
                    Glide.with(getApplicationContext()).load(backgroundimageUrl).into(backgroundImage);
                }else{
                    Glide.with(getApplicationContext()).load(posterimageUrl).into(backgroundImage);
                }
                Glide.with(getApplicationContext()).load(posterimageUrl).into(posterImageView);
                if(movieDetailsModel.getGenres().size()>=1){
                StringBuilder s=new StringBuilder();
                for(int i = 0; i< movieDetailsModel.getGenres().size(); i++){
                    s.append(movieDetailsModel.getGenres().get(i).getName()+",");
                }
                String genres=s.substring(0,s.length()-1);
                genresTV.setText(genres);}
            }
        });
    }
}
