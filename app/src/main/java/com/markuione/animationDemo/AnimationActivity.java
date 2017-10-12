package com.markuione.animationDemo;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.markuione.R;
import com.markuione.animationDemo.customAnimation.CircleAngleAnimation;
import com.markuione.animationDemo.customViews.Circle;

public class AnimationActivity extends AppCompatActivity {

    private Circle circle;
    private android.widget.Button btnDraw;
    private Circle circle2;
    private android.widget.ImageView ivanimatedellipse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
//        this.ivanimatedellipse = (ImageView) findViewById(R.id.iv_animated_ellipse);
        this.circle2 = (Circle) findViewById(R.id.circle2);
        this.btnDraw = (Button) findViewById(R.id.btnDraw);
        circle = (Circle) findViewById(R.id.circle);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, 295);
                animation.setDuration(1000);
                circle.startAnimation(animation);

                CircleAngleAnimation animation2 = new CircleAngleAnimation(circle2, 295);
                animation.setDuration(1000);
//                circle2.startAnimation(animation2);
//                ((Animatable) ((ImageView) findViewById(R.id.iv_animated_ellipse)).getDrawable()).start();

            }
        });
    }


}
