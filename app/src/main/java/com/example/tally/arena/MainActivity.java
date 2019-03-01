package com.example.tally.arena;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.tally.arena.view.IndexSwipeAdapter;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        IndexSwipeAdapter adapt = new IndexSwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapt);
        viewPager.setCurrentItem(1);
    }

}
