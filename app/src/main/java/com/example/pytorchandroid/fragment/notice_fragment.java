package com.example.pytorchandroid.fragment;



import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.MainActivity;
import com.example.pytorchandroid.R;

public class notice_fragment extends Fragment implements View.OnClickListener{


    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notice, container, false);
        Button button = (Button) view.findViewById(R.id.notice_button);
        button.setOnClickListener(this);
        return view;
    }

    public void onClick(View view){

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.picachu);
        mediaPlayer.start();
    }
}
