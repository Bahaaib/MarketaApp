package com.example.bahaa.marketa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class BookFragment extends Fragment {

    //Another Fragment, same stupidity :)
    public int[] bookCoverList = {R.drawable.dance,
            R.drawable.sophie,
            R.drawable.trial,
            R.drawable.sugar,
            R.drawable.silmarillion,
            R.drawable.right,
            R.drawable.flower,
            R.drawable.brothers};

    public String[] bookTitleList = {"Dance Dance Dance", "Sophie's World", "The Trial", "Sugar Street","The Silmarillion",
            "The Rightous Mind", "The perks of being a wallflower", "The brothers Karamazov"};

    public String[] bookPriceList = {"29.99", "24.99", "7.99", "49.99", "29.99", "49.99", "14.99", "19.99"};

    public String[] bookAuthList = {"Haruki Murakami", "Jostein Gaarder", "Franz Kafka","Naguib Mahfouz", "J.R.R.Tolkien",
            "Jonathan Haidt", "Stephen Chbosky", "Fyodor Dostoevsky"};


    public ArrayList<BookModel> marketBooks;
    public RecyclerView bookRV;
    BookRecyclerAdapter bookAdapter;
    GridLayoutManager gridLayoutManager;


    public BookFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_book, container, false);

        marketBooks = new ArrayList<>();
        bookRV = (RecyclerView) v.findViewById(R.id.bookRecyclerView);

        for(int i=0; i<bookTitleList.length; i++){
            BookModel bookModel = new BookModel();

            bookModel.setBookTitle(bookTitleList[i]);
            bookModel.setBookAuthor(bookAuthList[i]);
            bookModel.setBookPrice(bookPriceList[i]);
            bookModel.setBookImgRef(bookCoverList[i]);

            marketBooks.add(bookModel);
        }

        bookAdapter = new BookRecyclerAdapter(this.getActivity(), marketBooks);
        bookRV.setAdapter(bookAdapter);

        gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

        bookRV.setLayoutManager(gridLayoutManager);

        return v;
    }


}
