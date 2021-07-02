package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class HomeFragment extends Fragment {
    private Button learnButton, quizButton, subiecteButton, settingsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        learnButton = (Button) view.findViewById(R.id.buttonLearn);
        learnButton.setOnClickListener(v -> learnButtonFunction());

        quizButton = (Button) view.findViewById(R.id.buttonQuiz);
        subiecteButton = (Button) view.findViewById(R.id.buttonSubiecte);
        settingsButton = (Button) view.findViewById(R.id.buttonSettings);

        learnButton.setOnTouchListener((v, event) -> {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    learnButton.setTextColor(Color.parseColor("#FFFFFF"));
                    learnButton.setBackgroundResource(R.drawable.buttonblack);
                    break;
                case MotionEvent.ACTION_UP:
                    learnButton.setTextColor(Color.parseColor("#000000"));
                    learnButton.setBackgroundResource(R.drawable.buttonwhite);
                    break;
            }
            return true;
        });

        quizButton.setOnTouchListener((v, event) -> {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    quizButton.setTextColor(Color.parseColor("#FFFFFF"));
                    quizButton.setBackgroundResource(R.drawable.buttonblack);
                    break;
                case MotionEvent.ACTION_UP:
                    quizButton.setTextColor(Color.parseColor("#000000"));
                    quizButton.setBackgroundResource(R.drawable.buttonwhite);
                    break;
            }
            return true;
        });

        subiecteButton.setOnTouchListener((v, event) -> {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    subiecteButton.setTextColor(Color.parseColor("#FFFFFF"));
                    subiecteButton.setBackgroundResource(R.drawable.buttonblack);
                    break;
                case MotionEvent.ACTION_UP:
                    subiecteButton.setTextColor(Color.parseColor("#000000"));
                    subiecteButton.setBackgroundResource(R.drawable.buttonwhite);
                    break;
            }
            return true;
        });

        settingsButton.setOnTouchListener((v, event) -> {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    settingsButton.setTextColor(Color.parseColor("#FFFFFF"));
                    settingsButton.setBackgroundResource(R.drawable.buttonblack);
                    break;
                case MotionEvent.ACTION_UP:
                    settingsButton.setTextColor(Color.parseColor("#000000"));
                    settingsButton.setBackgroundResource(R.drawable.buttonwhite);
                    break;
            }
            return true;
        });

        return view;
    }

    public void learnButtonFunction()
    {
        //
    }
}
