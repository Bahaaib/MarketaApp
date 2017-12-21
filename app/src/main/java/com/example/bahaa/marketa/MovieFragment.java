package com.example.bahaa.marketa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MovieFragment extends Fragment {


    //Another Fragment, same stupidity :)
    public int[] moviesmallList = {R.drawable.dunkirk,
            R.drawable.mother,
            R.drawable.wheel,
            R.drawable.murder,
            R.drawable.coco,
            R.drawable.ghost};

    public int[] movieCoverList = {R.drawable.dunkirk_c,
            R.drawable.mother_c,
            R.drawable.wheel_c,
            R.drawable.murder_c,
            R.drawable.coco_c,
            R.drawable.ghost_c};

    public String[] movieTitleList = {"Dunkirk", "Mother", "Wonder Wheel", "Mudrder on the orient express",
            "Coco", "A Ghost Story"};

    public String[] moviePlotList = {"In May 1940, Germany advanced into France, trapping Allied troops on the beaches of Dunkirk. Under air and ground cover from British and French forces, troops were slowly and methodically evacuated from the beach using every serviceable naval and civilian vessel that could be found",
            "A couple's relationship is tested when uninvited guests arrive at their home, disrupting their tranquil existence. From filmmaker Darren Aronofsky (Black Swan, Requiem for a Dream), mother! stars Jennifer Lawrence, Javier Bardem, Ed Harris and Michelle Pfeiffer in this riveting psychological thriller about love, devotion and sacrifice.'.",
            "Four peoples' lives intertwine amid the hustle and bustle of the Coney Island amusement park in the 1950s: Ginny, an emotionally volatile former actress now working as a waitress in a clam house; Humpty, Ginny's rough-hewn carousel operator husband; Mickey, a handsome young lifeguard who dreams of becoming a playwright; and Carolina, Humpty's long-estranged daughter, who is now hiding out from gangsters at her father's apartment.",
            "A lavish trip through Europe quickly unfolds into a race against time to solve a murder aboard a train. When an avalanche stops the Orient Express dead in its tracks, the world's greatest detective -- Hercule Poirot -- arrives to interrogate all passengers and search for clues before the killer can strike again.",
            "Despite his family's generations-old ban on music, young Miguel dreams of becoming an accomplished musician like his idol Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead. After meeting a charming trickster named Héctor, the two new friends embark on an extraordinary journey to unlock the real story behind Miguel's family history.",
            "A passionate young couple, unexpectedly separated by a shocking loss, discover an eternal connection and a love that is infinite."};

    public String[] moviePriceList = {"99.99", "149.99", "49.99", "64.99", "99.99", "119.99"};


    public ArrayList<MovieModel> marketMovies;
    public RecyclerView movieRV;
    MovieRecyclerAdapter movieAdapter;
    LinearLayoutManager linearLayoutManager;


    public MovieFragment() {
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
        View v = inflater.inflate(R.layout.fragment_movie, container, false);


        marketMovies = new ArrayList<>();
        movieRV = (RecyclerView) v.findViewById(R.id.movieRecyclerView);

        for(int i=0; i<movieCoverList.length; i++){
            MovieModel movieModel = new MovieModel();

            movieModel.setCoverImgRef(movieCoverList[i]);
            movieModel.setSmallImgRef(moviesmallList[i]);
            movieModel.setMovieTitle(movieTitleList[i]);
            movieModel.setMoviePlot(moviePlotList[i]);
            movieModel.setMoviePrice(moviePriceList[i]);

            marketMovies.add(movieModel);
        }


        movieAdapter = new MovieRecyclerAdapter(this.getActivity(), marketMovies);
        movieRV.setAdapter(movieAdapter);

        //Showing the RecyclerView Elements using the Linear Scheme, 1 Card in each row, propagating vertically,
        //Wrapping all passed cards with no limit
        linearLayoutManager = new LinearLayoutManager(getActivity());

        movieRV.setLayoutManager(linearLayoutManager);




        return v;
    }





}
