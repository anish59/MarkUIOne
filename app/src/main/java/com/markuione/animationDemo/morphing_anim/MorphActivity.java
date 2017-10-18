package com.markuione.animationDemo.morphing_anim;

import android.animation.Animator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.markuione.R;
import com.markuione.animationDemo.customViews.PathView;

public class MorphActivity extends AppCompatActivity {

    private android.widget.ImageView img;
    private android.widget.Button btnAnimateView;
    private ImageView img2;
    private ImageView img3;
    private Button btnReset;
    private Button btnDrawAnim;
    private com.markuione.animationDemo.customViews.PathView path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morph);
        this.path = (PathView) findViewById(R.id.path);
        this.btnDrawAnim = (Button) findViewById(R.id.btnDrawAnim);
        this.btnReset = (Button) findViewById(R.id.btnReset);
        this.img3 = (ImageView) findViewById(R.id.img3);
        this.img2 = (ImageView) findViewById(R.id.img2);
        this.btnAnimateView = (Button) findViewById(R.id.btnAnimateView);
        this.img = (ImageView) findViewById(R.id.img);

        initListener();
    }

    private void initListener() {
        btnAnimateView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.animatable_add_to_square);
                img.setImageDrawable(drawable);
                drawable.start();
                AnimatedVectorDrawable drawable2 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.animatable_hamberger_to_cross);
                img2.setImageDrawable(drawable2);
                drawable2.start();
                AnimatedVectorDrawable drawable3 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.animatable_menu_to_list);
                img3.setImageDrawable(drawable3);
                drawable3.start();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.rev_animatable_add_to_square);
                img.setImageDrawable(drawable);
                drawable.start();
                AnimatedVectorDrawable drawable1 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.rev_animatable_hamberger_to_cross);
                img2.setImageDrawable(drawable1);
                drawable1.start();
                AnimatedVectorDrawable drawable2 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.rev_animatable_menu_to_list);
                img3.setImageDrawable(drawable2);
                drawable2.start();
            }
        });

        btnDrawAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path.init(PathView.TRIANGLE, 3000, new PathView.PathViewAnimListener() {
                    @Override
                    public void onAnimationOver(Animator animator) {
                        Toast.makeText(MorphActivity.this, "animOver", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimStart(Animator animator) {
                        Toast.makeText(MorphActivity.this, "animStarts", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimCanceled(Animator animator) {

                    }

                    @Override
                    public void onAnimRepeat(Animator animator) {

                    }
                });
            }
        });
    }
}


/*

you need 4 to 6 (+ 1 for api 21 vector) files to make this shape shifter kind of animation,
1. vector_hamberg.xml (a simple vector image file inside drawable)
2. clockwise-rotation.xml (inside anim)
3. morph_hamberg_arrow.xml (inside anim)
4. animatable_hamberger_to_cross.xml (inside drawable)

for reverse animation
1. rev_morph_add_square.xml (reverse morphing;inside anim)
2. rev_animatable_add_to_square.xml (reverse animation; inside drawable)
* */
