package com.practise.googlenewspractiseusingmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.practise.googlenewspractiseusingmvvm.Model.Articles;
import com.practise.googlenewspractiseusingmvvm.R;

import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
List<Articles> articlesList;
Context context;

    public newsAdapter(List<Articles> articlesList, Context context) {
        this.articlesList = articlesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custam_news,parent, false);

        return new newsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof newsHolder){

          //  ((newsHolder) holder).text_date.setText(articlesList.get(position).get);
           // ((newsHolder) holder).text_date.setText(articlesList.get(position).get);
            ((newsHolder) holder).text_title.setText(articlesList.get(position).getTitle());
            ((newsHolder) holder).text_news.setText(articlesList.get(position).getContent());
//            ((newsHolder) holder).image.setText(articlesList.get(position).get);

/*
            Glide.with(context)
                    .load(articlesList.get(position).getUrlToImage())
                    .error(R.drawable.ic_launcher_background)
                    .into(((newsHolder) holder).relatvie_background);
*//*
Glide.with(context).load(articlesList.get(position).getUrlToImage())
        .into(((newsHolder) holder).relatvie_background)*/
        /*    Glide.with(context)
                    .load(articlesList.get(position).getUrlToImage())
                    .error(R.drawable.ic_launcher_background)
                    .into(((newsHolder) holder).relatvie_background));*/

          Glide.with(context).
                  load(articlesList.get(position).getUrlToImage())
                  .error(R.drawable.ic_launcher_background)
                  .into(((newsHolder) holder).image);
        }



    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }


    public class newsHolder extends RecyclerView.ViewHolder{
        TextView text_source, text_date, text_title,text_news;
        ImageView image;
        RelativeLayout relatvie_background;

        public newsHolder(@NonNull View itemView) {
            super(itemView);

            text_source=itemView.findViewById(R.id.textViewName);
            text_date=itemView.findViewById(R.id.tv_date);
            text_title =itemView.findViewById(R.id.tv_heading);
            text_news=itemView.findViewById(R.id.tv_news);
            image=itemView.findViewById(R.id.image);



        }
    }
}
