package com.example.myapplication;

import android.content.Intent;
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
    private Button learnButton, settingsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        learnButton = (Button) view.findViewById(R.id.buttonLearn);
        learnButton.setOnClickListener(v -> learnButtonFunction());
        settingsButton = (Button) view.findViewById(R.id.buttonSettings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFragment settingsFragment = new SettingsFragment();
                FragmentManager manager = getParentFragmentManager();
                manager.beginTransaction().replace(R.id.fragment_container, settingsFragment, settingsFragment.getTag()).commit();
            }
        });
        return view;

    }

    public void learnButtonFunction() {
        Intent intent = new Intent(getActivity(), LearnActivity1.class);
        startActivity(intent);
    }
}
