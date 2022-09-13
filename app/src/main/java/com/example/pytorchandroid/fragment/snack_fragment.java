package com.example.pytorchandroid.fragment;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.HomeActivity;
import com.example.pytorchandroid.objectdetection.ObjectDetectionActivity;
import com.example.pytorchandroid.R;
import com.example.pytorchandroid.utility.Constants;

public class snack_fragment extends Fragment implements View.OnClickListener{

    private Context context;
    private int mDoubleClickFlag = 0;
    private MediaPlayer mediaPlayer;

    public snack_fragment( Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.snack_explain);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.snack, container, false);
        Button button = (Button) view.findViewById(R.id.snack_button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        mDoubleClickFlag++;
        Handler handler = new Handler();
        Runnable clickRunnable = new Runnable() {
            @Override
            public void run() {
                if (mDoubleClickFlag >= 2) {
                    ((HomeActivity)context).startTextToString("과자탐지를 시작합니다!");
                    Intent intent = new Intent(getActivity(), ObjectDetectionActivity.class);
                    intent.putExtra("modelType", "snack");
                    startActivity(intent);
                }
                else {
                    if (mediaPlayer == null){
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.snack_explain);
                    }
                    mediaPlayer.start();
                }
                mDoubleClickFlag = 0;
            }
        };
        if( mDoubleClickFlag == 1 ) {
            handler.postDelayed( clickRunnable, Constants.CLICK_DELAY );
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((HomeActivity)context).startTextToString("과자탐지메뉴입니다.");
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.snack_explain);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer =null;
        }
    }
}
