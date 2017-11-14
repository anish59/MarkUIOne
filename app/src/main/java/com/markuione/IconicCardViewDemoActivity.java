package com.markuione;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import customWidgets.IconicCardView;

public class IconicCardViewDemoActivity extends AppCompatActivity {

    private customWidgets.IconicCardView iconicCV;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = IconicCardViewDemoActivity.this;
        setContentView(R.layout.activity_iconic_card_view_demo);
        iconicCV = (IconicCardView) findViewById(R.id.iconicCV);
        View view = LayoutInflater.from(context).inflate(R.layout.dummy_layout, null, false);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,500);
        view.setLayoutParams(layoutParams);
        iconicCV.addInsideView(view);
    }
}
