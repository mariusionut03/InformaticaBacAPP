package com.example.myapplication;

import android.annotation.SuppressLint;
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

import org.w3c.dom.Text;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    private TextView learnButton, quizButton, subiecteButton, settingsButton, feedbackButton;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String CHAPTER = "chapter";
    public static final String PAGE = "page";
    private boolean theme;
    private String chapterString, pageString;

    public TextView learn1Text, learn2Text, learn3Text, titleText, textView4, textView5, textView6, textView7;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);


        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
        chapterString = sharedPreferences.getString(CHAPTER, "0");
        pageString = sharedPreferences.getString(PAGE, "0");
        chapterString = String.valueOf(Integer.parseInt(chapterString) + 1);
        pageString = String.valueOf(Integer.parseInt(pageString) + 1);

        learnButton = (TextView) view.findViewById(R.id.buttonLearn);
        quizButton = (TextView) view.findViewById(R.id.buttonQuiz);
        subiecteButton = (TextView) view.findViewById(R.id.buttonSubiecte);
        settingsButton = (TextView) view.findViewById(R.id.buttonSettings);
        feedbackButton = (TextView) view.findViewById(R.id.buttonFeedback);

        learn1Text = (TextView) view.findViewById(R.id.textViewLearn1);
        learn2Text = (TextView) view.findViewById(R.id.textViewLearn2);
        learn3Text = (TextView) view.findViewById(R.id.textViewLearn3);
        titleText = (TextView) view.findViewById(R.id.titleHome);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);
        textView7 = (TextView) view.findViewById(R.id.textView7);

        learn2Text.setText("Capitolul " + chapterString);
        learn3Text.setText("Pagina " + pageString);

        learnButton.setOnClickListener(v -> learnButtonFunction());
        settingsButton.setOnClickListener(v -> {
            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentManager manager = getParentFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, settingsFragment, settingsFragment.getTag()).commit();
        });

        learnButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                learnButton.setElevation(1);
                return false;
            }
        });

        learnButton.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                learnButton.setElevation(1);
                return false;
            }
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
            learnButton.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            quizButton.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            subiecteButton.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            settingsButton.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            feedbackButton.setBackgroundResource(R.drawable.style_bg_dark_ripple);

            learnButton.setTextColor(Color.parseColor("#FFFFFF"));
            quizButton.setTextColor(Color.parseColor("#FFFFFF"));
            subiecteButton.setTextColor(Color.parseColor("#FFFFFF"));
            settingsButton.setTextColor(Color.parseColor("#FFFFFF"));
            feedbackButton.setTextColor(Color.parseColor("#FFFFFF"));
            learn1Text.setTextColor(Color.parseColor("#FFFFFF"));
            learn2Text.setTextColor(Color.parseColor("#FFFFFF"));
            learn3Text.setTextColor(Color.parseColor("#FFFFFF"));
            titleText.setTextColor(Color.parseColor("#FFFFFF"));
            textView4.setTextColor(Color.parseColor("#FFFFFF"));
            textView5.setTextColor(Color.parseColor("#FFFFFF"));
            textView6.setTextColor(Color.parseColor("#FFFFFF"));
            textView7.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
}
