package com.example.pytorchandroid.fragment;



import android.content.Context;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
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

public class notice_fragment extends Fragment implements View.OnClickListener{


    private MediaPlayer mediaPlayer;
    private Context context;

    public notice_fragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.message);
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
    public void onResume() {
        super.onResume();
        ((HomeActivity)context).startTextToString("안내문구");

    }

    public void onClick(View view){
        mediaPlayer.start();
    }

    //mp3 재생 리소스 지워주기
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer =null;
        }
    }
}
