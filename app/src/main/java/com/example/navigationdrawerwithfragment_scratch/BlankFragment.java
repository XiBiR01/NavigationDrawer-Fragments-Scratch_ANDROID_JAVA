package com.example.navigationdrawerwithfragment_scratch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    public static final String ARG_TEXT="key";
    String fragmentText;
    TextView textView;
    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String fragmentText){
        BlankFragment frag=new BlankFragment();
        Bundle args=new Bundle();
        args.putString(ARG_TEXT,fragmentText);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);;
        textView=view.findViewById(R.id.textView);
        if (getArguments()!=null){
            fragmentText=getArguments().getString(ARG_TEXT);
        }
        textView.setText(fragmentText);
        return view;
    }
}