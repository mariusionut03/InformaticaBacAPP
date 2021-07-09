package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    private Button learnButton, quizButton, subiecteButton, settingsButton, feedbackButton;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    private boolean theme;

    public TextView learn1Text, learn2Text, learn3Text, titleText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);


        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);

        learnButton = (Button) view.findViewById(R.id.buttonLearn);
        quizButton = (Button) view.findViewById(R.id.buttonQuiz);
        subiecteButton = (Button) view.findViewById(R.id.buttonSubiecte);
        settingsButton = (Button) view.findViewById(R.id.buttonSettings);
        feedbackButton = (Button) view.findViewById(R.id.buttonFeedback);

        learn1Text = (TextView) view.findViewById(R.id.textViewLearn1);
        learn2Text = (TextView) view.findViewById(R.id.textViewLearn2);
        learn3Text = (TextView) view.findViewById(R.id.textViewLearn3);
        titleText = (TextView) view.findViewById(R.id.titleHome);

        learnButton.setOnClickListener(v -> learnButtonFunction());
        settingsButton.setOnClickListener(v -> {
            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentManager manager = getParentFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, settingsFragment, settingsFragment.getTag()).commit();
        });


        loadThemeFunction();
        return view;
    }

    public void learnButtonFunction() {
        Intent intent = new Intent(getActivity(), LearnActivity1.class);
        startActivity(intent);
    }

    private void loadThemeFunction()
    {
        if(theme == true)
        {
            learnButton.setBackgroundResource(R.drawable.style_bg_dark);
            quizButton.setBackgroundResource(R.drawable.style_bg_dark);
            subiecteButton.setBackgroundResource(R.drawable.style_bg_dark);
            settingsButton.setBackgroundResource(R.drawable.style_bg_dark);
            feedbackButton.setBackgroundResource(R.drawable.style_bg_dark);

            learnButton.setTextColor(Color.parseColor("#FFFFFF"));
            quizButton.setTextColor(Color.parseColor("#FFFFFF"));
            subiecteButton.setTextColor(Color.parseColor("#FFFFFF"));
            settingsButton.setTextColor(Color.parseColor("#FFFFFF"));
            feedbackButton.setTextColor(Color.parseColor("#FFFFFF"));
            learn1Text.setTextColor(Color.parseColor("#FFFFFF"));
            learn2Text.setTextColor(Color.parseColor("#FFFFFF"));
            learn3Text.setTextColor(Color.parseColor("#FFFFFF"));
            titleText.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
}
