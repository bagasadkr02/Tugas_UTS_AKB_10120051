package com.memmoo.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.memmoo.R;
import com.memmoo.adapter.VPAdapter;
import com.memmoo.model.ViewPagerItem;

// 10120051
// Muhammad Bagas Adikara
// IF - 2
public class InfoAppFragment extends Fragment {

    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_info_app, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = getView().findViewById(R.id.viewpager);
        int[] images = {R.drawable.photo1,R.drawable.photo2,R.drawable.photo3};
        String[] desc = {getString(R.string.a_desc),
                getString(R.string.b_desc),
                getString(R.string.c_desc),};

        viewPagerItemArrayList = new ArrayList<>();

        for (int i =0; i< images.length ; i++){

            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i],desc[i]);
            viewPagerItemArrayList.add(viewPagerItem);

        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);

        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

    }

}