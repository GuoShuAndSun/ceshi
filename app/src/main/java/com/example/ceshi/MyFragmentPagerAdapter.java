package com.example.ceshi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> fragmentList=new ArrayList<>();
    //选择参数多的构造方法
    public MyFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> fragments) {
        super(fragmentManager, lifecycle);
        fragmentList=fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
