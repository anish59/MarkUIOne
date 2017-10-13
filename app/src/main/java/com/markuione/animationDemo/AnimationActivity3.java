package com.markuione.animationDemo;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.markuione.R;

public class AnimationActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation3);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_vector_download);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
