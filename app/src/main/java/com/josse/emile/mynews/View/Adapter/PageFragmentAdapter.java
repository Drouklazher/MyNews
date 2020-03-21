package com.josse.emile.mynews.View.Adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.josse.emile.mynews.View.Fragments.PageFragment;

public class PageFragmentAdapter extends FragmentStatePagerAdapter {


    public PageFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        PageFragment pageFragment = new PageFragment();
        Bundle bundle = new Bundle();
        position = position + 1;
        bundle.putInt("pos",position );
        pageFragment.setArguments(bundle);

        return pageFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
