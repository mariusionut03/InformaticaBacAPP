package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String REFRESH = "refreshTheme";
    public boolean theme;
    public FrameLayout frameLayout;
    public BottomNavigationView bottomNav;
    public boolean appRefreshTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.fragment_container);
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        appRefreshTheme = sharedPreferences.getBoolean(REFRESH, false);

        if(appRefreshTheme == true)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(REFRESH, false);
            editor.apply();
            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, settingsFragment, settingsFragment.getTag()).commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        LoadDataMainActivity();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.homeNav:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.learnNav:
                            selectedFragment = new LearnFragment();
                            break;
                        case R.id.practiceNav:
                            selectedFragment = new PracticeFragment();
                            break;
                        case R.id.settingsNav:
                            selectedFragment = new SettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    public void LoadDataMainActivity()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);

        if(theme == false)
        {

        }
        else
        {
            frameLayout.setBackgroundColor(Color.parseColor("#000c2e"));
            bottomNav.setBackgroundColor(Color.parseColor("#011c08"));
            bottomNav.setItemIconTintList(ContextCompat.getColorStateList(this, R.color.colors_menu_dark));
            bottomNav.setItemTextColor(ContextCompat.getColorStateList(this, R.color.colors_menu_dark));

        }
    }

    public static void refreshApp(AppCompatActivity appCompatActivity){
        appCompatActivity.recreate();
    }
}