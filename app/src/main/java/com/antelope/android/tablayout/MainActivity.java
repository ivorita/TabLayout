package com.antelope.android.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.antelope.android.tablayout.adapter.MyAdapter;
import com.antelope.android.tablayout.fragment.Fragment1;
import com.antelope.android.tablayout.fragment.Fragment2;
import com.antelope.android.tablayout.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = findViewById(R.id.view_pager);

        initPager();

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    private void initPager() {
        mMyAdapter = new MyAdapter(getSupportFragmentManager());
        mMyAdapter.addFragment(new Fragment1());
        mMyAdapter.addFragment(new Fragment2());
        mMyAdapter.addFragment(new Fragment3());
        mViewPager.setAdapter(mMyAdapter);

    }


}
