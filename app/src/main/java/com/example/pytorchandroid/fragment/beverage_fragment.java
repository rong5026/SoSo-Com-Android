package com.example.pytorchandroid.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.HomeActivity;
import com.example.pytorchandroid.objectdetection.ObjectDetectionActivity;
import com.example.pytorchandroid.R;

public class beverage_fragment extends Fragment implements View.OnClickListener{

    private TextToSpeech textToSpeech;
    private Context context;

    public beverage_fragment(TextToSpeech textToSpeech, Context context) {
        this.textToSpeech =textToSpeech;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.beverage, container, false);
        Button button = (Button) view.findViewById(R.id.beverage_button);
        button.setOnClickListener(this);
        return view;
    }
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ObjectDetectionActivity.class);
        intent.putExtra("modelType", "beverage");
        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();
        ((HomeActivity)context).startTextToString("음료");
    }
}
