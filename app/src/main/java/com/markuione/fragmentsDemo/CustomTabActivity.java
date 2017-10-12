package com.markuione.fragmentsDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.markuione.R;
import com.markuione.fragmentsDemo.adpater.ViewPagerAdapter;
import com.markuione.fragmentsDemo.fragments.FragOne;
import com.markuione.fragmentsDemo.fragments.FragThree;
import com.markuione.fragmentsDemo.fragments.FragTwo;

public class CustomTabActivity extends AppCompatActivity {

    private android.support.design.widget.TabLayout tabs;
    private android.support.v4.view.ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        init();
    }


    private void init() {
        this.viewpager = (ViewPager) findViewById(R.id.viewpager);
        this.tabs = (TabLayout) findViewById(R.id.tabs);
        setUpViewPager();
        tabs.setupWithViewPager(viewpager);
        setupTabIcons();

    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("ONE");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,0 , 0, 0);
        tabs.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("TWO");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,0 , 0, 0);
        tabs.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("THREE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,0 , 0, 0);
        tabs.getTabAt(2).setCustomView(tabThree);
    }

    private void setUpViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragOne(), "One");
        adapter.addFragment(new FragTwo(), "Two");
        adapter.addFragment(new FragThree(), "Three");
        viewpager.setAdapter(adapter);
    }

}
