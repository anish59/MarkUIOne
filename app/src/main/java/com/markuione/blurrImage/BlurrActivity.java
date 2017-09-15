package com.markuione.blurrImage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.markuione.R;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class BlurrActivity extends AppCompatActivity {

    private android.widget.TextView txt;
    private eightbitlab.com.blurview.BlurView blurView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blurr);

        this.blurView = (BlurView) findViewById(R.id.blurView);
        this.txt = (TextView) findViewById(R.id.txt);

        setUpBlurView();
        rotateCards();
    }

    private void rotateCards() {
        RotateAnimation ranim = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.tilt_view);
        /*ranim.setFillAfter(true);*/
    }

    private void setUpBlurView() {
        final float radius = 10;

        final View decorView = getWindow().getDecorView();
        //Activity's root View. Can also be root View of your layout (preferably)
        final ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //set background, if your root layout doesn't have one
        final Drawable windowBackground = decorView.getBackground();

        blurView.setupWith(rootView)
                .windowBackground(windowBackground)
                .blurAlgorithm(new RenderScriptBlur(this))
                .blurRadius(radius);
    }
}
