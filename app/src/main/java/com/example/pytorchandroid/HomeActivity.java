package com.example.pytorchandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.pytorchandroid.fragment.beverage_fragment;
import com.example.pytorchandroid.fragment.noodle_fragment;
import com.example.pytorchandroid.fragment.notice_fragment;
import com.example.pytorchandroid.fragment.snack_fragment;

public class HomeActivity extends FragmentActivity{


    private static final int NUM_PAGES = 4;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private long backKeyPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        viewPager = findViewById(R.id.pager);
        viewPager.setPageTransformer(new DepthPageTransformer());

        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);


    }


    // 뒤로가기 버튼 이벤트
    @Override
    public void onBackPressed() {

        if(System.currentTimeMillis() > backKeyPressedTime + 1500){
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this,"한번더 버튼을 누르시면 종료됩니다",Toast.LENGTH_SHORT).show();
            return;
        }

        if(System.currentTimeMillis() <= backKeyPressedTime + 1500){
            moveTaskToBack(true);
            finishAndRemoveTask();
            System.exit(0);
        }
    }


    // Fragment 전환
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {

            if(position==0) return new notice_fragment();
            else if(position==1)  return new beverage_fragment();
            else if(position==2)  return new noodle_fragment();
            else return new snack_fragment();

        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
