package com.example.bahaa.marketa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Bahaa on 12/16/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    //Setting up the View Pager with tabs
    private int mTabsNum;
    public PagerAdapter(FragmentManager fm, int tabsNum) {
        super(fm);
        this.mTabsNum = tabsNum;
    }

    //Here we control the flow of the pager, What Fragment to go on clicking to which Tab..
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GameFragment gameFragment = new GameFragment();
                return gameFragment;
            case 1:
                MovieFragment movieFragment = new MovieFragment();
                return movieFragment;
            case 2:
                BookFragment bookFragment = new BookFragment();
                return bookFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabsNum;
    }
}
