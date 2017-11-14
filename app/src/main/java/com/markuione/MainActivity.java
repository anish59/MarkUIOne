package com.markuione;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView note;
    private android.support.v7.widget.CardView card;
    private android.widget.Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = (Button) findViewById(R.id.btnClick);
        this.card = (CardView) findViewById(R.id.card);
        this.note = (TextView) findViewById(R.id.note);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                card.startAnimation(animation);


                ObjectAnimator animation = ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 360f);
                animation.setDuration(3600);
                animation.setRepeatCount(ObjectAnimator.INFINITE);
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                animation.setTarget(card);
                animation.start();

                /*Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rnd1);*/
                /*  Animation a = new RotateAnimation(0.0f, 360.0f,
                        Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RESTART,
                        0.5f);
                a.setRepeatCount(-1);
                a.setDuration(1000);
                card.startAnimation(a);*/
               /* ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip_slide);
                anim.setTarget(card);
                anim.setDuration(3000);
                anim.start();*/
            }
        });
    }


}


/*   FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment fragment= new MainFragment();
        fragmentTransaction.add(R.id.fragment1, fragment, "HELLO");
        fragmentTransaction.commit();*/