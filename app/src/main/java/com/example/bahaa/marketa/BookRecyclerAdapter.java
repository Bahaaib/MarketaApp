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

/**
 * Created by Bahaa on 12/19/2017.
 */

public class BookRecyclerAdapter extends RecyclerView.Adapter {

    //Here we recieve from the calling Fragment :
    // The cards container List & The Parent Activity context
    private Context context;
    private ArrayList<BookModel> adapterModel;

    {
        adapterModel = new ArrayList<>();
    }

    public BookRecyclerAdapter(Context context, ArrayList<BookModel> adapterModel) {
        this.context = context;
        this.adapterModel = adapterModel;
    }

    //Here We tell the RecyclerView what to show at each element of it..it'd be a cardView!
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.book_card, parent, false);
        return new BookViewHolder(view);
    }

    //Here We tell the RecyclerView what to show at each CardView..
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BookViewHolder) holder).BindView(position);

    }

    @Override
    public int getItemCount() {
        return adapterModel.size();
    }

    //Here we bind all the children views of each cardView with their corresponding
    // actions to show & interact with them
    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView bookTitle, bookPrice, bookAuthor;
        ImageView bookCover;


        public BookViewHolder(View itemView) {
            super(itemView);

            bookTitle = (TextView) itemView.findViewById(R.id.bookCardTitle);
            bookAuthor = (TextView) itemView.findViewById(R.id.bookAuthor);
            bookPrice = (TextView) itemView.findViewById(R.id.bookPriceValue);

            bookCover = (ImageView) itemView.findViewById(R.id.bookCardImage);


        }

        //Here where all the glory being made..!
        public void BindView(final int position) {

            bookTitle.setText(adapterModel.get(position).getBookTitle());
            bookAuthor.setText(adapterModel.get(position).getBookAuthor());
            bookPrice.setText(adapterModel.get(position).getBookPrice() + "$");

            bookCover.setImageResource(adapterModel.get(position).getBookImgRef());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Implement some sexy animation in the transition to/from each card to the next Activity.. ;)
                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                            bookCover, "SelectedBook").toBundle();

                    Intent bookIntent = new Intent(context, BookDetailsActivity.class);
                    //Transfer all the card data to the details activity for further use..
                    bookIntent.putExtra("bookCoverImg", adapterModel.get(position).getBookImgRef());
                    bookIntent.putExtra("bookSummary", adapterModel.get(position).summary[position]);
                    bookIntent.putExtra("bookTitle", adapterModel.get(position).getBookTitle());
                    bookIntent.putExtra("bookPrice", Float.parseFloat(adapterModel.get(position).getBookPrice()));
                    context.startActivity(bookIntent, bundle);
                }
            });


        }


    }
}

