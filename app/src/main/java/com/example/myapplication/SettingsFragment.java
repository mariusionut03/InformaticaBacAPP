package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {

    private Switch switchTheme;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String REFRESH = "refreshTheme";
    private boolean switchOnOff;


    private TextView settingsTitle, chooseThemeTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        switchTheme = (Switch) view.findViewById(R.id.switchTheme);
        settingsTitle = (TextView) view.findViewById(R.id.settingsTitle);
        chooseThemeTextView = (TextView) view.findViewById(R.id.chooseThemeTextView);

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    settingsTitle.setTextColor(Color.parseColor("#FFFFFF"));
                    chooseThemeTextView.setTextColor(Color.parseColor("#FFFFFF"));
                }
                saveThemeData(isChecked);
            }
        });

        switchTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshAppFunctionSettings();
            }
        });

        loadDataSettings();
        updateViews();
        return view;
    }

    public void saveThemeData(boolean isChecked) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(THEME, switchTheme.isChecked());
        editor.apply();
    }

    public void loadDataSettings() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        switchOnOff = sharedPreferences.getBoolean(THEME, false);
        if (switchOnOff == true)
        {
            settingsTitle.setTextColor(Color.parseColor("#FFFFFF"));
            chooseThemeTextView.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public void updateViews() {
        switchTheme.setChecked(switchOnOff);
    }

    public void refreshAppFunctionSettings()
    {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(REFRESH, true);
        editor.apply();
        MainActivity.refreshApp((AppCompatActivity) getActivity());
    }
}


