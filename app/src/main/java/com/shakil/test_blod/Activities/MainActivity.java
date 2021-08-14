package com.shakil.test_blod.Activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.shakil.test_blod.Fragments.Dasbord;
import com.shakil.test_blod.Fragments.History;
import com.shakil.test_blod.Fragments.Profile;
import com.shakil.test_blod.R;

public class MainActivity extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Dasbord()).commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.dasbord:
                        fragment = new Dasbord();
                        break;
                    case R.id.history:
                        fragment = new History();
                        break;
                    case R.id.profile:
                        fragment = new Profile();
                        break;

                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }
            }
        });
    }
}