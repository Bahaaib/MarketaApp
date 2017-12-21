package com.example.bahaa.marketa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by Bahaa on 12/15/2017.
 */

public class GameRecyclerAdapter extends RecyclerView.Adapter {

    //Here we recieve from the calling Fragment :
    // The cards container List & The Parent Activity context
    private Context context;
    private ArrayList<GameModel> adapterModel;

    {
        adapterModel = new ArrayList<>();
    }

    public GameRecyclerAdapter(Context context, ArrayList<GameModel> adapterModel) {
        this.context = context;
        this.adapterModel = adapterModel;
    }

    //Here We tell the RecyclerView what to show at each element of it..it'd be a cardView!
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.game_card, parent, false);
        return new GameViewHolder(view);
    }

    //Here We tell the RecyclerView what to show at each CardView..
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GameViewHolder) holder).BindView(position);

    }

    @Override
    public int getItemCount() {
        return adapterModel.size();
    }

    //Here we bind all the children views of each cardView with their corresponding
    // actions to show & interact with them
    public class GameViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImage;
        TextView cardTitle, rateValue;
        MaterialRatingBar ratingBar;

        public GameViewHolder(View itemView) {
            super(itemView);

            cardImage = (ImageView) itemView.findViewById(R.id.cardImage);
            cardTitle = (TextView) itemView.findViewById(R.id.cardTitle);
            rateValue = (TextView) itemView.findViewById(R.id.priceValue);
            ratingBar = (MaterialRatingBar) itemView.findViewById(R.id.ratingBar);

        }


        //Here where all the glory being made..!
        public void BindView(final int position) {


            cardImage.setImageResource(adapterModel.get(position).getImageRef());
            cardTitle.setText(adapterModel.get(position).getGameTitle());
            rateValue.setText(adapterModel.get(position).getPriceValue() + "$");

            ratingBar.setRating(adapterModel.get(position).getRateValue());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Implement some sexy animation in the transition to/from each card to the next Activity.. ;)
                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                            cardImage, "SelectedGame").toBundle();

                    Intent intent = new Intent(context, GameDetailsActivity.class);

                    //Transfer all the card data to the details activity for further use..
                    intent.putExtra("coverImg", adapterModel.get(position).getImageRef());
                    intent.putExtra("smallImg", adapterModel.get(position).getImageRef());

                    intent.putExtra("title", adapterModel.get(position).getGameTitle());
                    intent.putExtra("plot", adapterModel.get(position).getPlot(position));
                    intent.putExtra("date", "Release Date: " + adapterModel.get(position).getDate(position));
                    intent.putExtra("mode", "Modes: " + adapterModel.get(position).getMode(position));
                    intent.putExtra("dev", "Developers: " + adapterModel.get(position).getDev(position));
                    intent.putExtra("platform", "Platforms: " + adapterModel.get(position).getPlatform(position));

                    intent.putExtra("price", Float.parseFloat(adapterModel.get(position).getPriceValue()));
                    context.startActivity(intent, bundle);

                }
            });

        }


    }
}
