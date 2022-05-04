package com.example.myapplication;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PracticeFragment extends Fragment {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String SUBIECT = "numarSubiect";

    private boolean theme;

    public TextView button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, practiceTitle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_practice,
                container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);
        button9 = view.findViewById(R.id.button9);
        button10 = view.findViewById(R.id.button10);
        button11 = view.findViewById(R.id.button11);
        practiceTitle = view.findViewById(R.id.practiceTitle);

        button1.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "1");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button2.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "2");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button3.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "3");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button4.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "4");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button5.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "5");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button6.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "6");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button7.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "7");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button8.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "8");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button9.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "9");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button10.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "10");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });
        button11.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SUBIECT, "11");
            editor.apply();
            Intent intent = new Intent(getActivity(), subiecteActivity.class);
            startActivity(intent);
        });

        loadThemeFunction();
        return view;
    }



    private void loadThemeFunction()
    {
        if(theme == true)
        {
            button1.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button2.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button3.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button4.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button5.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button6.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button7.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button8.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button9.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button10.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button11.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            button1.setTextColor(Color.parseColor("#FFFFFF"));
            button2.setTextColor(Color.parseColor("#FFFFFF"));
            button3.setTextColor(Color.parseColor("#FFFFFF"));
            button4.setTextColor(Color.parseColor("#FFFFFF"));
            button5.setTextColor(Color.parseColor("#FFFFFF"));
            button6.setTextColor(Color.parseColor("#FFFFFF"));
            button7.setTextColor(Color.parseColor("#FFFFFF"));
            button8.setTextColor(Color.parseColor("#FFFFFF"));
            button9.setTextColor(Color.parseColor("#FFFFFF"));
            button10.setTextColor(Color.parseColor("#FFFFFF"));
            button11.setTextColor(Color.parseColor("#FFFFFF"));
            practiceTitle.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
}
