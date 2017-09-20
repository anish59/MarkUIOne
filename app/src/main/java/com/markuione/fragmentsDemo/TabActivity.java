package com.markuione.fragmentsDemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.markuione.R;

public class TabActivity extends AppCompatActivity {

    private android.support.design.widget.TabLayout tabs;
    private android.support.v4.view.ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        init();


    }

    private void init() {
        this.viewpager = (ViewPager) findViewById(R.id.viewpager);
        this.tabs = (TabLayout) findViewById(R.id.tabs);

    }
}
