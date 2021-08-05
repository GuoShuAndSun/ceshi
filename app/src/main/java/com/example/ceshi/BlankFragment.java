package com.example.ceshi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BlankFragment extends Fragment {


    Context context;
    //自己定义一个标记
    private static final String TITLE1 = "param1";
    private String mParam1;

    View rootView;




    public BlankFragment() {
        // Required empty public constructor
        this.context=context;
    }


    public static BlankFragment newInstance(Context context) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //使用Budnle 对Activity和Fragment之间通信
        if (getArguments() != null) {
            mParam1 = getArguments().getString(TITLE1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       //为了避免每次都创建view 要提前做一下判断做一下优化
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_blank, container, false);


        }
        initView1();
        return rootView;
    }

    private void initView1() {
        //TextView textView=rootView.findViewById(R.id.fragment_title);
        //textView.setText(mParam1);
    }



}