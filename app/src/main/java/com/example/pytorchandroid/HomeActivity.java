package com.example.pytorchandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
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
import com.example.pytorchandroid.utility.Constants;

import java.util.Locale;

public class HomeActivity extends FragmentActivity{



    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private long backKeyPressedTime = 0;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        viewPager = findViewById(R.id.pager);
        viewPager.setPageTransformer(new DepthPageTransformer());

        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.KOREAN);
                }

            }
        });



    }

    // 뒤로가기 버튼 이벤트
    @Override
    public void onBackPressed() {

        if(System.currentTimeMillis() > backKeyPressedTime + 6000){
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, Constants.END_RECONFIRM,Toast.LENGTH_SHORT).show();
            tts.speak(Constants.END_RECONFIRM, TextToSpeech.QUEUE_FLUSH,null);
            return;
        }

        if(System.currentTimeMillis() <= backKeyPressedTime + 6000){

            tts.speak(Constants.END_MESSAGE, TextToSpeech.QUEUE_FLUSH,null);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    moveTaskToBack(true);
                    finishAndRemoveTask();
                    System.exit(0);
                }
            },2000);

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
            return Constants.NUM_PAGES;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
}
