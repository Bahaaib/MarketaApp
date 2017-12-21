package com.example.bahaa.marketa;

/**
 * Created by Bahaa on 12/19/2017.
 */

public class MovieModel {

    public int coverImgRef, smallImgRef;
    public String movieTitle, moviePlot, moviePrice;

    public MovieModel(int coverImgRef, int smallImgRef, String movieDetails, String moviePlot, String moviePrice) {
        this.coverImgRef = coverImgRef;
        this.smallImgRef = smallImgRef;
        this.movieTitle = movieDetails;
        this.moviePlot = moviePlot;
        this.moviePrice = moviePrice;
    }
    public MovieModel() {
        //Required Empty constructor
    }


    public int getCoverImgRef() {
        return coverImgRef;
    }

    public int getSmallImgRef() {
        return smallImgRef;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMoviePlot() {
        return moviePlot;
    }

    public String getMoviePrice() {
        return moviePrice;
    }


    public void setCoverImgRef(int coverImgRef) {
        this.coverImgRef = coverImgRef;
    }

    public void setSmallImgRef(int smallImgRef) {
        this.smallImgRef = smallImgRef;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMoviePlot(String moviePlot) {
        this.moviePlot = moviePlot;
    }

    public void setMoviePrice(String moviePrice) {
        this.moviePrice = moviePrice;
    }
}
