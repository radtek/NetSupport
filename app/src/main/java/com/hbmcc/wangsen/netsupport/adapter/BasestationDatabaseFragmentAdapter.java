package com.hbmcc.wangsen.netsupport.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.GsmBasestationDatabaseFragment;
import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.LteBasestationDatabaseFragment;
import com.hbmcc.wangsen.netsupport.ui.fragment.forth.basestationdatabase.TdscdmaBasestationDatabaseFragment;

public class BasestationDatabaseFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public BasestationDatabaseFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return LteBasestationDatabaseFragment.newInstance();
        } else if(position == 1){
            return TdscdmaBasestationDatabaseFragment.newInstance();
        }else{
            return GsmBasestationDatabaseFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
