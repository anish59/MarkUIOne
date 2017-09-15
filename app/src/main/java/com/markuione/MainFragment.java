package com.markuione;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aphidmobile.flip.FlipViewController;

import java.util.ArrayList;

/**
 * Created by anish on 13-09-2017.
 */

public class MainFragment extends Fragment {
    private CardView card;
    private ArrayList<String> notes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.item_card_swipe,container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        card = (CardView)view.findViewById(R.id.card);
/*
        animation = AnimationUtils.loadAnimation(context, R.animator.flip_slide);
        card.setAnimation(animation);
*/
        notes = new ArrayList<>();
        notes.add("Come");
        notes.add("On");
        notes.add("Flip");
        notes.add("Me");


       /* AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.flip_slide);
        set.setTarget(card); // set the view you want to animate
        set.start();*/

        //You can also use FlipViewController.VERTICAL
        FlipViewController flipView = new FlipViewController(getActivity(), FlipViewController.HORIZONTAL);

        //We're creating a NoteViewAdapter instance, by passing in the current context and the
        //values to display after each flip
        flipView.setAdapter(new NoteViewAdapter(getActivity(),notes));

        getActivity().setContentView(flipView);
    }

}
