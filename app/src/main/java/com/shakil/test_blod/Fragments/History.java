package com.shakil.test_blod.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.shakil.test_blod.Adapter.Page_adapter;
import com.shakil.test_blod.R;

public class History extends Fragment {


    TabLayout tabLayout;
    TabItem tabItem1,tabItem2;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_history, container, false);

        tabLayout=view.findViewById(R.id.tab_id);
        tabItem1=view.findViewById(R.id.tab1_id);
        tabItem2=view.findViewById(R.id.tab2_id);
        viewPager=view.findViewById(R.id.view_pager_id);
        pagerAdapter=new Page_adapter(getChildFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));








        return view;
    }
}