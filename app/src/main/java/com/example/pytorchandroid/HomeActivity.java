package com.example.pytorchandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.pytorchandroid.fragment.beverage_fragment;
import com.example.pytorchandroid.fragment.noodle_fragment;
import com.example.pytorchandroid.fragment.notice_fragment;
import com.example.pytorchandroid.fragment.search_fragment;
import com.example.pytorchandroid.fragment.snack_fragment;
import com.example.pytorchandroid.objectdetection.AbstractCameraXActivity;
import com.example.pytorchandroid.utility.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends FragmentActivity{

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private long backKeyPressedTime = 0;
    public static TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        viewPager = findViewById(R.id.pager);
        viewPager.setPageTransformer(new DepthPageTransformer());

        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.KOREAN);
                }
            }
        });




    }

    // 뒤로가기 버튼 이벤트
    @Override
    public void onBackPressed() {

        if(System.currentTimeMillis() > backKeyPressedTime + 6000){
            backKeyPressedTime = System.currentTimeMillis();
            showTest(Constants.END_RECONFIRM);    //종료안내 텍스트문구
            startTextToString(Constants.END_RECONFIRM);  // 종료안내 음성문구
            return;
        }

        if(System.currentTimeMillis() <= backKeyPressedTime + 6000){

            startTextToString(Constants.END_MESSAGE);

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

            switch (position){
                case 0:
                    return new notice_fragment(HomeActivity.this);
                case 1:
                    return new search_fragment(HomeActivity.this);
                case 2:
                    return new beverage_fragment(HomeActivity.this);
                case 3:
                    return new noodle_fragment(HomeActivity.this);
                default:
                    return new snack_fragment(HomeActivity.this);
            }
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
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
            textToSpeech = null;
        }
    }

    // TTS
    public void startTextToString(String text){
        textToSpeech.speak(text, TextToSpeech. QUEUE_FLUSH,null);
    }
    public void startTextToStringAdd(String text){
        textToSpeech.speak(text, TextToSpeech. QUEUE_ADD,null);
    }

    //텍스트 문구
    public void showTest(String text){
        Toast.makeText(this, text,Toast.LENGTH_SHORT).show();
    }
}
