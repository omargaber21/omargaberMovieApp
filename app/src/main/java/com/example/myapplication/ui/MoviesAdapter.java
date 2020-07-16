package com.example.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.MoviesClient;
import com.example.myapplication.model.MoviesResponse;
import com.example.myapplication.model.MoviesResponseResults;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private List<MoviesResponseResults> moviesResponseResults =new ArrayList<>();

    private RecyclerViewOnClickListener listener;
    public void setListener(RecyclerViewOnClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
    holder.movieNameTV.setText(moviesResponseResults.get(position).getTitle());
    String imageUrl=MoviesClient.getInstance().IMAGE_BASE_URL+moviesResponseResults.get(position).getPoster_path();
        Glide.with(holder.movieIV.getContext()).load(imageUrl).into(holder.movieIV);
    }

    @Override
    public int getItemCount() {
        return moviesResponseResults.size();
        }
    public void setList(List<MoviesResponseResults> results){
        this.moviesResponseResults=results;
        notifyDataSetChanged();
    }


    public class MoviesViewHolder extends RecyclerView.ViewHolder{
        TextView movieNameTV;
        ImageView movieIV;
        public MoviesViewHolder(View itemView) {
            super(itemView);
            movieNameTV=itemView.findViewById(R.id.movieNameTV);
            movieIV=itemView.findViewById(R.id.movieIV);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if(listener!=null && position!=RecyclerView.NO_POSITION) {
                        listener.onClick(view, position);
                    }
                }
            });
        }

    }
    public interface RecyclerViewOnClickListener{
        void onClick(View view,int position);
    }
}
