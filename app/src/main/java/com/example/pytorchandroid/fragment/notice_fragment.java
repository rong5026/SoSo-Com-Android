package com.example.pytorchandroid.fragment;



import android.content.Context;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.HomeActivity;
import com.example.pytorchandroid.MainActivity;
import com.example.pytorchandroid.R;
import com.example.pytorchandroid.utility.Constants;

import java.io.IOException;

public class notice_fragment extends Fragment implements View.OnClickListener{


    private MediaPlayer mediaPlayer;
    private MediaPlayer explainPlayer;
    private Context context;
    private int mDoubleClickFlag = 0;

    public notice_fragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.first);
        explainPlayer = MediaPlayer.create(getActivity(), R.raw.main_explain);
        mediaPlayer.start();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notice, container, false);
        Button button = (Button) view.findViewById(R.id.notice_button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.first);
        explainPlayer.stop();
        explainPlayer = MediaPlayer.create(getActivity(), R.raw.main_explain);
    }


    @Override
    public void onResume() {
        super.onResume();
        ((HomeActivity)context).startTextToString("안내문구 페이지 입니다.");

    }

    public void onClick(View view){
        if (explainPlayer == null){
            explainPlayer = MediaPlayer.create(getActivity(), R.raw.main_explain);
        }
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.first);
        }
        explainPlayer.start();
    }

    //mp3 재생 리소스 지워주기
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer =null;
        }
        if(explainPlayer !=null){
            explainPlayer.release();
            explainPlayer =null;
        }
    }
}
