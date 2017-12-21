package com.example.bahaa.marketa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import static com.example.bahaa.marketa.CheckoutRecyclerAdapter.isRemoved;
import static com.example.bahaa.marketa.CheckoutRecyclerAdapter.removePos;
import static com.example.bahaa.marketa.MainActivity.discount;
import static com.example.bahaa.marketa.MainActivity.grandTotal;
import static com.example.bahaa.marketa.MainActivity.itemsList;
import static com.example.bahaa.marketa.MainActivity.pricesList;
import static com.example.bahaa.marketa.MainActivity.subTotal;


public class CheckoutActivity extends AppCompatActivity {


    ;
    public RecyclerView checkuotRV;
    public CheckoutRecyclerAdapter checkoutAdapter;
    public LinearLayoutManager linearLayoutManager;
    public TextView subPrice, discountPrice, grandPrice;

    public Float discountFactor;
    public Float gPrice, mPrice, bPrice;



    public SwipeRefreshLayout updateRefresher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Assigning all used objects to their views
        updateRefresher = (SwipeRefreshLayout) findViewById(R.id.updateRefresher);

        checkuotRV = (RecyclerView) findViewById(R.id.checkoutRV);


        checkoutAdapter = new CheckoutRecyclerAdapter(this, itemsList);

        checkuotRV.setAdapter(checkoutAdapter);

        linearLayoutManager = new LinearLayoutManager(this);

        checkuotRV.setLayoutManager(linearLayoutManager);


        subPrice = (TextView) findViewById(R.id.subPrice);
        discountPrice = (TextView) findViewById(R.id.disPrice);
        grandPrice = (TextView) findViewById(R.id.grandTotalPrice);

        //Gather all prices data from sending classes for final calculation
        gPrice = getIntent().getFloatExtra("gameFinalPrice", 0);
        mPrice = getIntent().getFloatExtra("movieFinalPrice", 0);
        bPrice = getIntent().getFloatExtra("bookFinalPrice", 0);


        //Fill the prices list with the category purchased!
        // THE TRICK: There will always be one category at a time has a price and the others 0's
        if (gPrice > 0) {
            pricesList.add(gPrice);
        } else if (mPrice > 0) {
            pricesList.add(mPrice);
        } else {
            pricesList.add(bPrice);
        }

        //Clearing the subtotal price everytime logging in to the activity to prevent previous carts accumulation
        subTotal = 0.0f;

        //Calcualting subtotal by adding all list prices
        for (int i = 0; i < pricesList.size(); i++) {
            subTotal += pricesList.get(i);
        }

        //Gather voucher Coupon if found,
        //If not, by default would calculate no discounts
        discountFactor = getIntent().getFloatExtra("vCoupon", 1);

        discount = (subTotal * discountFactor);
        grandTotal = subTotal - discount;

        //Showing current purchased items receipt
        subPrice.setText(String.format("%.2f", subTotal) + "$");
        discountPrice.setText(" - " + String.format("%.2f", discount) + "$");
        grandPrice.setText(String.format("%.2f", grandTotal) + "$");



        //Setting up A Swipe refresher to update the UI corresponding to any change occurs in data
        updateRefresher.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary));

        updateRefresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //If item removed, Re-Calcualte the receipt..
                if (isRemoved) {
                    subTotal -= pricesList.get(removePos);
                    pricesList.remove(removePos);
                    discount = (subTotal * discountFactor);
                    grandTotal = subTotal - discount;
                    isRemoved = false;

                }

                //Show the new receipt
                subPrice.setText(String.format("%.2f", subTotal) + "$");
                discountPrice.setText(" - " + String.format("%.2f", discount) + "$");
                grandPrice.setText(String.format("%.2f", grandTotal) + "$");

                //And notify RecyclerView Adapter to remove the corresponding card up from the UI
                checkoutAdapter.notifyDataSetChanged();

                //Let the circular disappear jumping back up after updating
                updateRefresher.setRefreshing(false);
            }
        });


    }

    // Return back to MainActivity on Back Pressed,
    //Clear the back Stack due to start the App flow normally from the start!
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(CheckoutActivity.this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);
        super.onBackPressed();
    }
}
