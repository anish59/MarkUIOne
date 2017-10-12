package com.markuione.fragmentsDemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.markuione.R;
import com.markuione.helper.AppConstants;

/**
 * Created by anish on 21-09-2017.
 */

public class TaxiFragment extends Fragment {

    private TextView text;
    private RelativeLayout fragmentContent;
    private String mText;
    private int mColor;

    public static Fragment newInstance(String text, int color) {
        Fragment frag = new TaxiFragment();
        Bundle args = new Bundle();
        args.putString(AppConstants.ARG_TEXT, text);
        args.putInt(AppConstants.ARG_COLOR, color);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_car, container, false);
        fragmentContent = (RelativeLayout) view.findViewById(R.id.fragment_content);
        text = (TextView) view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // retrieve text and color from bundle or savedInstanceState

        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(AppConstants.ARG_TEXT);
            mColor = args.getInt(AppConstants.ARG_COLOR);
        } else {
            mText = savedInstanceState.getString(AppConstants.ARG_TEXT);
            mColor = savedInstanceState.getInt(AppConstants.ARG_COLOR);
        }

        // initialize views
        fragmentContent = view.findViewById(R.id.fragment_content);
        text = (TextView) view.findViewById(R.id.text);

        // set text and background color
        text.setText(mText);
        fragmentContent.setBackgroundColor(mColor);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(AppConstants.ARG_TEXT, mText);
        outState.putInt(AppConstants.ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }
}
