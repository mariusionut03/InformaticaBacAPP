package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {

    private Switch switchTheme;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    private boolean switchOnOff;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        switchTheme = (Switch) view.findViewById(R.id.switchTheme);

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveThemeData(isChecked);
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

    public void loadDataSettings()
    {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        switchOnOff = sharedPreferences.getBoolean(THEME, false);
    }

    public void updateViews() {
        switchTheme.setChecked(switchOnOff);
    }
}


