package com.example.bahaa.marketa;

import java.io.Serializable;

/**
 * Created by Bahaa on 12/18/2017.
 */

public class CheckoutModel implements Serializable{

    private String checkTitle;
    private int checkImg;
    private Integer checkQty;

    public CheckoutModel(String checkTitle, Integer checkQty, int checkImg) {
        this.checkTitle = checkTitle;
        this.checkQty = checkQty;
        this.checkImg = checkImg;
    }

    public CheckoutModel() {
        //Required empty constructor
    }

    public String getCheckTitle() {
        return checkTitle;
    }

    public void setCheckTitle(String checkTitle) {
        this.checkTitle = checkTitle;
    }

    public Integer getCheckQty() {
        return checkQty;
    }

    public void setCheckQty(Integer checkQty) {
        this.checkQty = checkQty;
    }

    public int getCheckImg() {
        return checkImg;
    }

    public void setCheckImg(int imageRef) {
        this.checkImg = imageRef;
    }


}
