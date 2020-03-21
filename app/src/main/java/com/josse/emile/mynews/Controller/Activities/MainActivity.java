package com.josse.emile.mynews.Controller.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.josse.emile.mynews.View.Adapter.PageFragmentAdapter;
import com.josse.emile.mynews.R;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PageFragmentAdapter mPageFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.activity_main_viewpager);
        mPageFragmentAdapter = new PageFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageFragmentAdapter);
    }
}
