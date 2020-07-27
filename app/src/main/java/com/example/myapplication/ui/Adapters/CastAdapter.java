package com.example.myapplication.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.MoviesInterface;
import com.example.myapplication.model.MovieDetailsModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {
    private MoviesAdapter.RecyclerViewOnClickListener listener;

    private List<MovieDetailsModel.CreditsBean.CastBean> castBeanList=new ArrayList<>();
    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CastViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_layout,parent,false));
    }

    public void setListener(MoviesAdapter.RecyclerViewOnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
    holder.characterTextView.setText(castBeanList.get(position).getCharacter());
    holder.actorTextView.setText(castBeanList.get(position).getName());
        String imageUrl= MoviesInterface.IMAGE_BASE_URL +castBeanList.get(position).getProfile_path();
        Glide.with(holder.castImage.getContext()).load(imageUrl).into(holder.castImage);
    }

    @Override
    public int getItemCount() {
        return castBeanList.size();
    }
    public void setCastBeanList(List<MovieDetailsModel.CreditsBean.CastBean> castBeanList) {
        this.castBeanList = castBeanList;
        notifyDataSetChanged();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {
        ImageView castImage;
        TextView actorTextView,characterTextView;
        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            castImage=itemView.findViewById(R.id.castImageView);
            actorTextView=itemView.findViewById(R.id.actorNameTextView);
            characterTextView=itemView.findViewById(R.id.characterNameTextView);
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

}
