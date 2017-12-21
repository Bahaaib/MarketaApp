package com.example.bahaa.marketa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.bahaa.marketa.MainActivity.itemsList;


/**
 * Created by Bahaa on 12/18/2017.
 */

public class CheckoutRecyclerAdapter extends RecyclerView.Adapter {

    private Context cContext;
    private ArrayList<CheckoutModel> checkModel;
    public static boolean isRemoved;
    public static int removePos;


    {
        checkModel = new ArrayList<>();


    }

    public CheckoutRecyclerAdapter(Context context, ArrayList<CheckoutModel> adapterModel) {
        this.cContext = context;
        this.checkModel = adapterModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(cContext).inflate(R.layout.checkout_card, parent, false);
        return new CheckoutRecyclerAdapter.CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CheckoutRecyclerAdapter.CheckoutViewHolder) holder).BindView(position);

    }

    @Override
    public int getItemCount() {
        return checkModel.size();
    }

    public class CheckoutViewHolder extends RecyclerView.ViewHolder {

        TextView cardTitle, cardQty;
        ImageView cardImage, deleteIcon;


        public CheckoutViewHolder(View itemView) {
            super(itemView);
            cardTitle = (TextView) itemView.findViewById(R.id.checkTitle);
            cardQty = (TextView) itemView.findViewById(R.id.checkQty);
            cardImage = (ImageView) itemView.findViewById(R.id.checkImg);
            deleteIcon = (ImageView) itemView.findViewById(R.id.delImg);


        }

        public void BindView(final int position) {


            cardTitle.setText(checkModel.get(position).getCheckTitle());
            cardQty.setText("(" + checkModel.get(position).getCheckQty().toString() + ")");
            cardImage.setImageResource(checkModel.get(position).getCheckImg());

            deleteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //When an item is deleted from the checkout Recyclerview, set the flags to alert Checkout Activity,
                    //Send its exact position in the List
                    //Then delete it from the List
                    isRemoved = true;
                    removePos = position;

                    itemsList.remove(itemsList.get(position));
                    Toast.makeText(cContext, "Item Removed!", Toast.LENGTH_LONG).show();

                }
            });
        }


    }
}
