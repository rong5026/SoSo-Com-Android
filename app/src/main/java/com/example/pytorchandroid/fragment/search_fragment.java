package com.example.pytorchandroid.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.HomeActivity;
import com.example.pytorchandroid.R;
import com.example.pytorchandroid.objectdetection.ObjectDetectionActivity;

public class search_fragment extends Fragment implements View.OnClickListener{


    private Context context;

    public search_fragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search, container, false);
        Button button = (Button) view.findViewById(R.id.search_button);
        button.setOnClickListener(this);
        return view;
    }
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ObjectDetectionActivity.class);
        intent.putExtra("modelType", "noodle");
        startActivity(intent);
    }
    @Override
    public void onResume() {
        super.onResume();
        ((HomeActivity)context).startTextToString("검색");
    }

}
