package com.example.myapplication.ui.Activities;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.data.MoviesInterface;
import com.example.myapplication.model.MovieTrailers;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MovieTrailerActivity extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    List<String> listVideos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_trailer);
        youTubePlayerView=findViewById(R.id.youtube);

        MovieTrailers movieTrailers= (MovieTrailers) getIntent().getSerializableExtra("movieTrailers");
        if(movieTrailers!=null){
            listVideos=new ArrayList<>();
                for(int i=0;i<movieTrailers.getResults().size();i++) {
                    listVideos.add(movieTrailers.getResults().get(i).getKey());
                }
        youTubePlayerView.initialize(MoviesInterface.YT_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideos(listVideos);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });



    }
}}
