package com.example.tally.arena.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tally.arena.control.CadastrarArena;
import com.example.tally.arena.control.CadastrarUser;
import com.example.tally.arena.control.Login;

public class IndexSwipeAdapter extends FragmentStatePagerAdapter {
    public IndexSwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment result = null;
        switch (i){
            case 0: result = new CadastrarArena();  break;
            case 1: result = new Login();           break;
            case 2: result = new CadastrarUser();   break;
        }
        return result;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
