package com.josse.emile.mynews.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.josse.emile.mynews.Model.POJOS.ArticlePojo;
import com.josse.emile.mynews.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    private ArrayList<ArticlePojo> mArticleList;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<ArticlePojo> articleList, Context context) {
        mArticleList = articleList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mArticleList.get(position).getImageUrl())
                .into(holder.articleImage);

        holder.articleTitre.setText(mArticleList.get(position).getTitle());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mArticleList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView articleImage;
        TextView articleTitre;
        LinearLayout parentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            articleImage = itemView.findViewById(R.id.image);
            articleTitre = itemView.findViewById(R.id.title);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
