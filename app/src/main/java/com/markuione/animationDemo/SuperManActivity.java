package com.markuione.animationDemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.markuione.R;

import java.util.Random;

public class SuperManActivity extends AppCompatActivity {

    private android.view.View viewAnime;
    private Button btnStartAnime;
    private Context context;
    private int translationX;
    private TranslateAnimation anim; //Use current view position instead of `currentX` and `currentY`
    private Button BtnStartAnime;
    private android.widget.ImageView imgSuperMan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);
        this.imgSuperMan = (ImageView) findViewById(R.id.imgSuperMan);
        this.BtnStartAnime = (Button) findViewById(R.id.BtnStartAnime);
        viewAnime = (View) findViewById(R.id.viewAnime);
        btnStartAnime = (Button) findViewById(R.id.BtnStartAnime);
        //init();
        imgSuperMan.setVisibility(View.GONE);
        initListener();


    }

    private void initListener() {
        btnStartAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSuperMan.setVisibility(View.VISIBLE);

                /*ObjectAnimator move = ObjectAnimator.ofFloat(viewAnime, "translationY", 100f);
                move.setDuration(3000);

                ObjectAnimator alpha1 = ObjectAnimator.ofFloat(viewAnime, "alpha", 0.5f);
                alpha1.setDuration(1000);
                ObjectAnimator alpha2 = ObjectAnimator.ofFloat(viewAnime, "alpha", 0);
                alpha2.setDuration(2000);
                AnimatorSet animset = new AnimatorSet();
                animset.play(alpha2).before(alpha1).with(move);
                animset.start();*/


              //super man effect
                ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_PARENT, .5f, ScaleAnimation.RELATIVE_TO_SELF, .5f);
                scale.setDuration(3000);
                scale.setInterpolator(new AnticipateOvershootInterpolator());
                imgSuperMan.setImageDrawable(getResources().getDrawable(R.drawable.superman));
                imgSuperMan.startAnimation(scale);
                scale.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imgSuperMan.setImageDrawable(getResources().getDrawable(R.drawable.superman_stand));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

//                viewAnime.animate().alpha(0).setInterpolator(new CycleInterpolator(4));
            }
        });
    }

    private void init() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;

        Random r = new Random();
        int translationX = r.nextInt(width);
        int translationY = r.nextInt(height);

        anim = new TranslateAnimation(width, translationX, height, translationY);
        anim.setDuration(5000);
        anim.setFillAfter(true);
    }


}
