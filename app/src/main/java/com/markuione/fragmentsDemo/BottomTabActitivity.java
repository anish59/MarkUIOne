package com.markuione.fragmentsDemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.markuione.R;
import com.markuione.fragmentsDemo.fragments.FragOne;
import com.markuione.fragmentsDemo.fragments.TaxiFragment;
import com.markuione.helper.AppConstants;

import static com.markuione.helper.AppConstants.SELECTED_ITEM;

public class BottomTabActitivity extends AppCompatActivity {

    private BottomNavigationView bottomnavigation;
    private Context context;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_actitivity);
        bottomnavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        context = this;
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        initListener();
        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(AppConstants.SELECTED_ITEM, 0);
            selectedItem = bottomnavigation.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = bottomnavigation.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
    }

    private void initListener() {
        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
    }

    private void selectFragment(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.action_wash:
                fragment = TaxiFragment.newInstance("Wash", R.color.yellow);
                break;
            case R.id.action_taxi:
                fragment = TaxiFragment.newInstance("Taxi", R.color.yellow);
                break;
            case R.id.action_car:
                fragment = TaxiFragment.newInstance("Car", R.color.yellow);
                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i < bottomnavigation.getMenu().size(); i++) {
            MenuItem menuItem = bottomnavigation.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == mSelectedItem);
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, fragment, fragment.getTag());
            ft.commit();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MenuItem homeItem = bottomnavigation.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }
}
