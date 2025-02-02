package com.example.pytorchandroid.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.pytorchandroid.HomeActivity;
import com.example.pytorchandroid.MainActivity;
import com.example.pytorchandroid.R;
import com.example.pytorchandroid.objectdetection.ObjectDetectionActivity;
import com.example.pytorchandroid.utility.Constants;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class search_fragment extends Fragment implements View.OnClickListener{


    private Context context;
    private Intent intent;
    private SpeechRecognizer mRecognizer;
    private  TextView textView;
    private int mDoubleClickFlag = 0;
    private long delay;
    private MediaPlayer mediaPlayer;
    private int inputSpeak;

    public search_fragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.search_explain);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search, container, false);
        Button button = (Button) view.findViewById(R.id.search_button);
        button.setOnClickListener(this);
        if(Build.VERSION.SDK_INT >= 23){
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.INTERNET,
                    Manifest.permission.RECORD_AUDIO},Constants.PERMISSION);
        }
        textView = (TextView) view.findViewById(R.id.search_text);

        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getActivity().getPackageName()); // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR"); // 언어 설정

        inputSpeak = 1;

        return view;
    }
    private int matchObject(String type){

        List<String> txtList = new ArrayList<>(Arrays.asList("beverage.txt", "noodle.txt", "snack.txt"));


        for(String filename :txtList) {

            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(getActivity().getAssets().open(filename)));
                String line;
                while ((line = br.readLine()) != null) {

                    if(line.contains(type.replace(" ",""))){
                        return 1;
                    }
                }
            } catch (IOException e) {
                Log.e("Object Detection", "Error reading assets", e);
            }
        }
        return 0;
    }


    @Override
    public void onClick(View v) {
        mDoubleClickFlag++;
        Handler handler = new Handler();
        Runnable clickRunnable = new Runnable() {
            @Override
            public void run() {
                if (mDoubleClickFlag >= 2) {
                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.search_explain);
                    }

                    mRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity()); // 새 SpeechRecognizer 를 만드는 팩토리 메서드
                    mRecognizer.setRecognitionListener(listener); // 리스너 설정
                    mRecognizer.startListening(intent); // 듣기 시작
                }
                else {
                    if(System.currentTimeMillis() <= delay){
                        if(matchObject(textView.getText().toString())==1){
                            ((HomeActivity)context).startTextToString(textView.getText().toString() + "탐지를 시작합니다!");
                            Intent intent = new Intent(getActivity(), ObjectDetectionActivity.class);
                            intent.putExtra("modelType", textView.getText().toString());
                            startActivity(intent);
                        }
                        else{
                            HomeActivity.textToSpeech.speak("등록되지 않은 물품입니다. 다른물품을 검색해주세요.", TextToSpeech.QUEUE_ADD, null);
                            textView.setText("음성인식");
                        }
                    }
                    else{
                        if (mediaPlayer == null){
                            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.search_explain);
                        }
                        mediaPlayer.start();
                    }
                }
                mDoubleClickFlag = 0;
            }
        };
        if( mDoubleClickFlag == 1 ) {
            handler.postDelayed( clickRunnable, Constants.CLICK_DELAY );
        }
    }

    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            // 말하기 시작할 준비가되면 호출
            delay = 0;
            Toast.makeText(getActivity().getApplicationContext(),"음성인식 시작",Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onBeginningOfSpeech() {
            // 말하기 시작했을 때 호출
        }

        @Override
        public void onRmsChanged(float rmsdB) {
            // 입력받는 소리의 크기를 알려줌
        }

        @Override
        public void onBufferReceived(byte[] buffer) {
            // 말을 시작하고 인식이 된 단어를 buffer에 담음
        }

        @Override
        public void onEndOfSpeech() {
            // 말하기를 중지하면 호출
        }

        @Override
        public void onError(int error) {
            // 네트워크 또는 인식 오류가 발생했을 때 호출
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER 가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                    break;
            }

            Toast.makeText(getActivity().getApplicationContext(), "에러 발생 : " + message,Toast.LENGTH_SHORT).show();
            ((HomeActivity)context).startTextToString("에러 발생 : " + message);
        }

        @Override
        public void onResults(Bundle results) {
            // 인식 결과가 준비되면 호출
            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어줌
            ArrayList<String> matches =
                    results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for(int i = 0; i < matches.size() ; i++){
                textView.setText(matches.get(i));
            }



            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((HomeActivity)context).startTextToStringAdd("찾으시는 물건이");
                    ((HomeActivity)context).startTextToStringAdd(textView.getText().toString());
                    ((HomeActivity)context).startTextToStringAdd("맞으시면 3초안에 화면을 한번더 눌러주세요");
                }
            },500);
            delay = System.currentTimeMillis()+9000;
        }

        @Override
        public void onPartialResults(Bundle partialResults) {
            // 부분 인식 결과를 사용할 수 있을 때 호출
        }

        @Override
        public void onEvent(int eventType, Bundle params) {
            // 향후 이벤트를 추가하기 위해 예약
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        ((HomeActivity)context).startTextToString("검색메뉴 입니다.");


        if(mRecognizer!=null){
            mRecognizer.destroy();
            mRecognizer.cancel();
            mRecognizer=null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.search_explain);
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
