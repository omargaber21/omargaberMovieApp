package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.myapplication.R;
import com.example.myapplication.data.MoviesClient;

public class SecondActivity extends AppCompatActivity {
TextView overviewTV;
ImageView posterImageView;
TextView movieNameTV;
ImageView backgroundImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        posterImageView=findViewById(R.id.insideposterImageView);
        movieNameTV=findViewById(R.id.movieNameTV);
        backgroundImage=findViewById(R.id.backgroundIMG);
        overviewTV=findViewById(R.id.overview);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            String backgroundURL=extras.getString("background");
            String posterURL=extras.getString("poster");
            String backgroundimageUrl= MoviesClient.getInstance().IMAGE_BASE_URL+backgroundURL;
            String posterimageUrl= MoviesClient.getInstance().IMAGE_BASE_URL+posterURL;
            if(backgroundURL!=null){
                Glide.with(getApplicationContext()).load(backgroundimageUrl).into(backgroundImage);
            }else{
                Glide.with(getApplicationContext()).load(posterimageUrl).into(backgroundImage);
            }
            Glide.with(getApplicationContext()).load(posterimageUrl).into(posterImageView);
            movieNameTV.setText(extras.getString("moviename"));
            overviewTV.setText(extras.getString("overview"));

        }
    }
}
