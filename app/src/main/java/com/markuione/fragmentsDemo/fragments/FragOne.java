package com.markuione.fragmentsDemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.markuione.R;

/**
 * Created by anish on 20-09-2017.
 */

public class FragOne extends Fragment {
    private Context context;
    private TextView txt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_one, container, false);
        this.txt = (TextView) view.findViewById(R.id.txt);
        txt.setText(this.getClass().getSimpleName());
        return view;
    }

}
