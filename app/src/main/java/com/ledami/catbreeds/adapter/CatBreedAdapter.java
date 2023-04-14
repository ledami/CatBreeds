package com.ledami.catbreeds.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ledami.catbreeds.R;
import com.ledami.catbreeds.model.CatBreed;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatBreedAdapter extends RecyclerView.Adapter<CatBreedAdapter.ViewHolder> {
    private List<CatBreed> catBreeds;

    public void setCatBreeds(List<CatBreed> catBreeds) {
        this.catBreeds = catBreeds;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_breed_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CatBreed catBreed = catBreeds.get(position);
        holder.breedNameTextView.setText(catBreed.getBreedName());
        holder.imageImageView.setImageResource(R.drawable.default_cat);
        //Picasso.get().load(catBreed.getImageUrl()).into(holder.imageImageView);
        holder.originTextView.setText(catBreed.getOrigin());
        holder.intelligenceTextView.setText(String.valueOf(catBreed.getIntelligence()));
    }

    @Override
    public int getItemCount() {
        return catBreeds != null ? catBreeds.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView breedNameTextView;
        ImageView imageImageView;
        TextView originTextView;
        TextView intelligenceTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            breedNameTextView = itemView.findViewById(R.id.tv_breedName);
            imageImageView = itemView.findViewById(R.id.iv_image);
            originTextView = itemView.findViewById(R.id.tv_origin);
            intelligenceTextView = itemView.findViewById(R.id.tv_intelligence);
        }
    }
}