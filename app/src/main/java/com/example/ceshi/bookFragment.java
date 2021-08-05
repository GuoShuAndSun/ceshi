package com.example.ceshi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bookFragment extends Fragment {

    Context context;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bookFragment() {
        // Required empty public constructor
    }


    public static bookFragment newInstance(Context context) {

        bookFragment fragment = new bookFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false);
    }
}