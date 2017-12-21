package com.example.bahaa.marketa;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.bahaa.marketa.MainActivity.itemsList;

public class GameDetailsActivity extends AppCompatActivity {

    public ImageView coverImg, smallImg;
    public CardView detailsCard;
    public TextView title, plot, date, mode, dev, platform;
    public TextView gameCart;
    public PopupWindow popWindow;

    public EditText quantity, voucher;
    public TextView proceed;

    public Float gamePrice = 0.0f;

    public Integer itemQty = 1;

    public Float gameFinalPrice;

    public String voucherStr;

    public Float disFactor;

    Context context = GameDetailsActivity.this;  //Attaining Activity context for future using


    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        //Assigning all our objects to their corresponding views..
        relativeLayout = (RelativeLayout) findViewById(R.id.detRelativeLayout);

        coverImg = (ImageView) findViewById(R.id.movieDetCoverImg);
        smallImg = (ImageView) findViewById(R.id.smallImg);
        detailsCard = (CardView) findViewById(R.id.detailsCardView);

        title = (TextView) findViewById(R.id.txtTitle);
        plot = (TextView) findViewById(R.id.txtPlot);
        date = (TextView) findViewById(R.id.txtDate);
        mode = (TextView) findViewById(R.id.txtModes);
        dev = (TextView) findViewById(R.id.txtDev);
        platform = (TextView) findViewById(R.id.txtPlatform);

        gameCart = (TextView) findViewById(R.id.gameCart);



        //Starting card Animation Setup
        AnimatorSet animationSet = new AnimatorSet();

        //Translating Card in Y Scale
        ObjectAnimator cardBody = ObjectAnimator.ofFloat(detailsCard, View.TRANSLATION_Y, 70);
        cardBody.setDuration(2500);
        cardBody.setRepeatMode(ValueAnimator.REVERSE);
        cardBody.setRepeatCount(ValueAnimator.INFINITE);
        cardBody.setInterpolator(new LinearInterpolator());

        //Translating Game Small Cover in Y Scale
        ObjectAnimator gameCover = ObjectAnimator.ofFloat(smallImg, View.TRANSLATION_Y, 30);
        gameCover.setDuration(3000);
        gameCover.setRepeatMode(ValueAnimator.REVERSE);
        gameCover.setRepeatCount(ValueAnimator.INFINITE);
        gameCover.setInterpolator(new LinearInterpolator());

        animationSet.playTogether(cardBody, gameCover);
        animationSet.start();

        coverImg.setImageResource(getIntent().getIntExtra("coverImg", 1));
        smallImg.setImageResource(getIntent().getIntExtra("smallImg", 1));

        title.setText(getIntent().getStringExtra("title"));
        plot.setText(getIntent().getStringExtra("plot"));
        date.setText(getIntent().getStringExtra("date"));
        mode.setText(getIntent().getStringExtra("mode"));
        dev.setText(getIntent().getStringExtra("dev"));
        platform.setText(getIntent().getStringExtra("platform"));

        //Poping up the Purchasing info Window on clicking the text..
        gameCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onShowPopup(view);
            }
        });


    }


    //Here We describe everything about the Popup Window
    //Also declaring all its views here, NOTE: Not in the Activity above; They have different contexts!
    public void onShowPopup(View v) {

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // inflate the custom popup layout
        final View inflatedView = layoutInflater.inflate(R.layout.popwin_layout, null, false);

        RelativeLayout headerView = (RelativeLayout) inflatedView.findViewById(R.id.headerLayout);

        quantity = (EditText) inflatedView.findViewById(R.id.quantity);


        proceed = (TextView) inflatedView.findViewById(R.id.proceed);


        gamePrice = getIntent().getFloatExtra("price", 0);


        //Get device size
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        //set height depends on the device size making it responsive to almost all devices
        popWindow = new PopupWindow(inflatedView, width - 50, height - 50, true);

        //set a background drawable with round corners
        popWindow.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.popup_bg));

        popWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        //Set The Springy Animation style from the script in styles..
        popWindow.setAnimationStyle(R.style.PopupAnimation);

        //show the popup at bottom of the screen and set some margin at the bottom
        popWindow.showAtLocation(v, Gravity.BOTTOM, 0, 200);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean validCoupon, validQty;
                Intent checkoutIntent = new Intent(GameDetailsActivity.this, CheckoutActivity.class);

                //Find out the user input in Quantity field considering the input is 0 if left blank
                try {
                    itemQty = Integer.parseInt(quantity.getText().toString());

                } catch (NumberFormatException e) {
                    itemQty = 0;
                }
                gameFinalPrice = gamePrice * itemQty;

                voucher = (EditText) inflatedView.findViewById(R.id.voucher);
                voucherStr = voucher.getText().toString();

                //Check Voucher Coupon validation among 2 Coupons available OR no Coupon is OK!
                if (voucherStr.equals("OFF50")) {
                    disFactor = 0.5f;
                    validCoupon = true;


                } else if (voucherStr.equals("OFF25")) {
                    disFactor = 0.25f;
                    validCoupon = true;

                } else if (voucherStr.equals("")) {
                    disFactor = 0.0f;
                    validCoupon = true;
                } else {
                    validCoupon = false;
                }
                if (itemQty <= 0) {
                    validQty = false;
                } else {
                    validQty = true;
                }

                //Showing the snackbar upon the above fields states..
                if (!validQty && !validCoupon) {
                    createSnackbar("INVALID DATA IN BOTH FIELDS");

                } else if (!validQty) {
                    createSnackbar("NOT ALLOWED LESS THAN 1 PRODUCT");
                } else if (!validCoupon && validQty){
                    createSnackbar("COUPON MAY BE INVALID OR OUTDATED");
                }

               //Freeze the Popup window preventing it from moving to checkout if any field input is invalid!
                if (validCoupon && validQty) {
                    CheckoutModel model = new CheckoutModel();
                    model.setCheckImg(getIntent().getIntExtra("smallImg", 1));
                    model.setCheckTitle(getIntent().getStringExtra("title"));
                    model.setCheckQty(itemQty);


                    itemsList.add(model);

                    checkoutIntent.putExtra("itemList", itemsList);
                    checkoutIntent.putExtra("gameFinalPrice", gameFinalPrice);
                    checkoutIntent.putExtra("vCoupon", disFactor);

                    startActivity(checkoutIntent);

                }


            }
        });


    }

    //Snackbar Structure
    public void createSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        TextView snackbarText = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbarText.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        snackbar.show();

    }
}
