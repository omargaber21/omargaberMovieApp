package com.example.myapplication.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.model.MoviesResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
MoviesViewModel moviesViewModel;
RecyclerView recyclerView;
EditText searchEDT;

MoviesAdapter.RecyclerViewOnClickListener listener;
    String movieName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
         recyclerView=findViewById(R.id.recyclerview);
         searchEDT=findViewById(R.id.searchEditText);
         moviesViewModel =new ViewModelProvider(this).get(MoviesViewModel.class);
        moviesViewModel.getMovies("s");
         searchEDT.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void afterTextChanged(Editable editable) {
             movieName=searchEDT.getText().toString();
             moviesViewModel.getMovies(movieName);
             }
         });
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
}
