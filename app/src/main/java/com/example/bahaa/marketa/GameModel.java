package com.example.bahaa.marketa;

/**
 * Created by Bahaa on 12/15/2017.
 */

public class GameModel {

    public int imageRef;
    public String gameTitle;
    public String priceValue;
    public Float rateValue;


    public String[] plot = {
            "Game of Thrones is an episodic graphic adventure video game based on the TV series of the same name, which in turn, is based on George R. R. Martin's A Song of Ice and Fire fantasy series",
            "In Watch Dogs, players enter the dangerous world of Aiden Pearce, a new class of antihero whose ability to hack into any connected system could be his most powerful weapon.",
            "James Cameron's largely theoretical pop culture universe built around his 2009 movie Avatar just got theoretically bigger. Massive Entertainment",
            "The story is set in Ptolemaic Egypt and follows a Medjay named Bayek, whose fight to protect his people, leads him to create the Secret Order the Assassins",
            "The Journey is back for a second year on FIFA 18 as EA Sports' flagship game mode - and so, as expected, is protagonist Alex Hunter.",
            "Off the pitch, one of the main battlegrounds for soccer games is in their breadth and depth of modes.",
            "Call of Duty: Infinite Warfare is a first-person shooter video game developed by Infinity Ward and published by Activision",
            "To fulfil his mother's dying wish, Ajay Ghale travels to Kyrat to scatter her ashes. Before he can accomplish this, though, he must end a civil war between the Golden Path and Min's forces."
    };

    public String[] relDate = {
            "December 2014",
            "May 27, 2014",
            "December 1, 2009",
            "October 27, 2017",
            "September 29, 2017",
            "September 12, 2017",
            "November 4, 2016",
            "November 18, 2014"
    };

    public String[] modes = {
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer",
            "Single Player, Multiplayer"
    };

    public String[] devs = {
            "Telltale Games",
            "Ubisoft Montreal",
            "Ubisoft, Gameloft",
            "Ubisoft, Gameloft, Blue Byte",
            "Electronic Arts",
            "Konami Digital Entertainment, Never",
            "Infinity Ward",
            "Ubisoft Montreal"
    };

    public String[] platforms = {
            "PlayStaion, Windows, Xbox, All mobiles OS",
            "PlayStaion, Windows, Xbox",
            "PlayStaion, Windows, Xbox, Android",
            "PlayStaion, Windows, Xbox, All mobiles OS",
            "PlayStaion, Windows, Xbox, All mobiles OS, Nintendo Switch",
            "PlayStaion, Windows, Xbox, All mobiles OS",
            "PlayStaion, Windows, Xbox",
            "PlayStaion, Windows, Xbox",
    };

    public GameModel() {
    }

    public GameModel(int imageRef, String gameTitle, String priceValue, Float rateValue) {
        this.imageRef = imageRef;
        this.gameTitle = gameTitle;
        this.priceValue = priceValue;
        this.rateValue = rateValue;
    }

    public int getImageRef() {
        return imageRef;
    }

    public void setImageRef(int imageRef) {
        this.imageRef = imageRef;
    }

    public String getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(String priceValue) {
        this.priceValue = priceValue;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Float getRateValue() {
        return rateValue;
    }

    public void setRateValue(Float rateValue) {
        this.rateValue = rateValue;
    }

    public String getPlot(int position) {
        return plot[position];
    }

    public String getDate(int position) {
        return relDate[position];
    }

    public String getMode(int position) {
        return modes[position];
    }

    public String getDev(int position) {
        return devs[position];
    }

    public String getPlatform(int position) {
        return platforms[position];
    }
}

