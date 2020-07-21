package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.MoviesInterface;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.PersonDetails;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PersonActivity extends AppCompatActivity {
ImageView personImageView;
TextView knownForTextView,birthDayTextView,genderTextView,placeOfBirthTextView,personNameTextView;
ExpandableTextView bioTextView;
RecyclerView knownForRecyclerView;
MoviesAdapter moviesAdapter;
PersonDetailsViewModel personDetailsViewModel;
MoviesAdapter.RecyclerViewOnClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        personImageView=findViewById(R.id.profileImageView);
        knownForTextView=findViewById(R.id.textViewKnownFor);
        birthDayTextView=findViewById(R.id.textViewBirthday);
        genderTextView=findViewById(R.id.textViewGender);
        bioTextView=findViewById(R.id.textViewBio);
        personNameTextView=findViewById(R.id.textViewPersonName);
        placeOfBirthTextView=findViewById(R.id.textViewPlaceOfBirth);
        knownForRecyclerView=findViewById(R.id.recyclerViewKnownFor);
        moviesAdapter=new MoviesAdapter();
        knownForRecyclerView.setAdapter(moviesAdapter);
        knownForRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        personDetailsViewModel= new ViewModelProvider(this).get(PersonDetailsViewModel.class);
        int person_id= getIntent().getExtras().getInt("person_id");
        personDetailsViewModel.getPersonDetails(person_id);
        personDetailsViewModel.getCastKnownFor(person_id);
        personDetailsViewModel.personDetailsMutableLiveData.observe(this, new Observer<PersonDetails>() {
            @Override
            public void onChanged(PersonDetails personDetails) {
                Glide.with(personImageView).load(MoviesInterface.IMAGE_BASE_URL+personDetails.getProfile_path()).into(personImageView);
                knownForTextView.setText(personDetails.getKnown_for_department());
                birthDayTextView.setText(personDetails.getBirthday());
                if(personDetails.getGender()==1){genderTextView.setText("Female"); }
                if (personDetails.getGender()==2){genderTextView.setText("Male");}
                else{genderTextView.setText("-");}
                placeOfBirthTextView.setText(personDetails.getPlace_of_birth());
                personNameTextView.setText(personDetails.getName());
                bioTextView.setText(personDetails.getBiography());
            }
        });
        personDetailsViewModel.responseMutableLiveData.observe(this, new Observer<MoviesResponse>() {
            @Override
            public void onChanged(MoviesResponse moviesResponse) {
                moviesAdapter.setList(moviesResponse.getResults());
                listener=new MoviesAdapter.RecyclerViewOnClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent=new Intent(getApplicationContext(),MovieDetails.class);
                        intent.putExtra("movie_id",moviesResponse.getResults().get(position).getId());
                        startActivity(intent);
                    }
                };
                moviesAdapter.setListener(listener);
            }
        });
    }
}
