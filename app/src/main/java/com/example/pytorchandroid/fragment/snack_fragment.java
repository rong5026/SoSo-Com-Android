package com.example.pytorchandroid.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.ObjectDetectionActivity;
import com.example.pytorchandroid.R;

public class snack_fragment extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.snack, container, false);
        Button button = (Button) view.findViewById(R.id.snack_button);
        button.setOnClickListener(this);
        return view;
    }
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ObjectDetectionActivity.class);
        intent.putExtra("modelType", "snack");
        startActivity(intent);
    }
}
