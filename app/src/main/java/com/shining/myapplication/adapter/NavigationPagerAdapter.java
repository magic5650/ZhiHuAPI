package com.shining.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.shining.myapplication.activity.FirstActivity;
import com.shining.myapplication.fragment.exploreFragment;
import com.shining.myapplication.fragment.favoriteFragment;
import com.shining.myapplication.fragment.mainFragment;
import com.shining.myapplication.fragment.personFragment;

/**
 * Created by Administrator on 2016-11-08.
 */

public class NavigationPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private mainFragment myFragment1 = null;
    private favoriteFragment myFragment2 = null;
    private exploreFragment myFragment3 = null;
    private personFragment myFragment4 = null;


    public NavigationPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new mainFragment();
        myFragment2 = new favoriteFragment();
        myFragment3 = new exploreFragment();
        myFragment4 = new personFragment();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case FirstActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case FirstActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case FirstActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case FirstActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }
}
