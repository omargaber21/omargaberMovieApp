package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.MoviesResponseResults;

public class MainActivity extends AppCompatActivity {
MoviesViewModel moviesViewModel;
RecyclerView recyclerView;
EditText searchEDT;
MoviesAdapter.RecyclerViewOnClickListener listener;
    String movieName;
    MoviesResponse response;
Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView=findViewById(R.id.recyclerview);
         searchEDT=findViewById(R.id.searchEditText);
         btnSearch=findViewById(R.id.btnSearch);
         moviesViewModel =new ViewModelProvider(this).get(MoviesViewModel.class);
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
         recyclerView.setLayoutManager(new GridLayoutManager(this,2));
         recyclerView.setAdapter(moviesAdapter);
         moviesAdapter.setListener(listener);
         listener=new MoviesAdapter.RecyclerViewOnClickListener() {
             @Override
             public void onClick(View view, int position) {
                 Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                 intent.putExtra("overview",response.getResults().get(position).getOverview());
                 startActivity(intent);

             }
         };
         moviesViewModel.moviesResponseMutableLiveData.observe(this, new Observer<MoviesResponse>() {
             @Override
             public void onChanged(MoviesResponse moviesResponse) {
                 if(moviesResponse==null){
                     return;
                 }
                 response=moviesResponse;
             moviesAdapter.setList(response.getResults());

             System.out.println("Succs Ope");
             }
         });
    }
}
