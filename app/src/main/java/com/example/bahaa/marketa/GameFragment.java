package com.example.bahaa.marketa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class GameFragment extends Fragment {



    // Reference to all used images stored locally (Such a stupid thing declaring them that way, but i had no time to go the pretty way!!)
    public int[] imageList = {R.drawable.got,
            R.drawable.watch,
            R.drawable.avatar,
            R.drawable.assassin,
            R.drawable.fifa,
            R.drawable.pes,
            R.drawable.cod,
            R.drawable.farcry};

    public String[] gameList = {"Game of Thrones", "Watch Dogs", "Avatar", "Assassin's Creed",
            "Fifa 18", "PES 18", "COD: Infinite Warfare", "Far Cry 4"};

    public String[] priceValueList = {"69.99", "149.99", "79.99", "44.49", "99.99", "119.99", "99.99", "107.95"};
    public Float[] rateValueList = {3.5f, 3.0f, 4.0f, 4.5f, 3.0f, 4.5f, 4.5f, 4.5f};

    public ArrayList<GameModel> marketGames;
    public RecyclerView recyclerView;
    GameRecyclerAdapter adapter;
    GridLayoutManager gridLayoutManager;


    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        // Main list that holds all the games cards Objects to convey them later to the RecyclerView
        marketGames = new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.gameRecyclerView);

        //Filling cards objects with its data and store the cards into the list
        for (int i = 0; i < gameList.length; i++) {
            GameModel game = new GameModel();
            game.setImageRef(imageList[i]);
            game.setGameTitle(gameList[i]);
            game.setPriceValue(priceValueList[i]);
            game.setRateValue(rateValueList[i]);
            marketGames.add(game);
        }

        //Passing the full list to the RecyclerView adapter to show them,
        // Passing the Activity context too letting the adapter know which Activity is calling in the whole App
        adapter = new GameRecyclerAdapter(this.getActivity(), marketGames);
        recyclerView.setAdapter(adapter);

        //Showing the RecyclerView Elements using the GridView Scheme, 2 Cards in each row, propagating vertically,
        //Wrapping all passed cards with no limit
        gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);

        
        //Now, ShowTime... :)
        return v;
    }



}
