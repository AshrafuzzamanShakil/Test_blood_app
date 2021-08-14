package com.shakil.test_blod.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shakil.test_blod.Fragments.Tab1;
import com.shakil.test_blod.Fragments.Tab2;

public class Page_adapter extends FragmentPagerAdapter {

    int tabcount;
    public Page_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:return new Tab1();
            case 1:return new Tab2();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
