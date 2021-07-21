package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import static android.content.Context.MODE_PRIVATE;

public class LearnFragment extends Fragment {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String CHAPTER = "chapter";
    public static final String PAGE = "page";
    private boolean theme;
    private String chapterString, pageString;
    public Integer chapter, page;
    public RelativeLayout layout = null;

    public int i, nrChapters, nrOfAttributes, currentChapter;
    public String[] titleArray = new String[20];
    public String[] pagesArray = new String[20];
    public TextView[] buttonsArray = new TextView[20];
    public TextView[] titleArrayActually = new TextView[20];
    public TextView[] capitolArrayActually = new TextView[20];
    public TextView[] pagesArrayActually = new TextView[20];
    public TextView learnText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);

        layout = view.findViewById(R.id.layoutId);
        learnText = view.findViewById(R.id.learnTitle);
        i = 1; currentChapter = 0;

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
        chapterString = sharedPreferences.getString(CHAPTER, "0");
        pageString = sharedPreferences.getString(PAGE, "0");
        chapter = Integer.parseInt(chapterString);
        page = Integer.parseInt(pageString);

        fillTheArraysFromRes();

        for(int y = 1; y <= nrChapters; y++)
        {
            createTextViews();
        }

        for(int z = 0; z < nrChapters; z++)
        {
            int finalZ = z;
            buttonsArray[z].setOnClickListener(v -> openLearnActivity(finalZ));
        }

        setThemeFunction();
        return view;
    }

    public void createTextViews()
    {
        final TextView btn = new TextView(getContext());
        buttonsArray[currentChapter] = btn;
        btn.setId(i);
        final RelativeLayout.LayoutParams paramsBtn =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(i == 1)
            paramsBtn.addRule(RelativeLayout.BELOW, R.id.learnTitle);
        else {
            paramsBtn.addRule(RelativeLayout.BELOW, (i-nrOfAttributes));
        }
        paramsBtn.setMargins(0, 65, 0, 0);
        btn.setLayoutParams(paramsBtn);
        btn.setHeight(275);
        btn.setBackgroundResource(R.drawable.style_bg_light_ripple);
        layout.addView(btn, paramsBtn);


        final TextView capitol = new TextView(getContext());
        capitolArrayActually[currentChapter] = capitol;
        capitol.setId(++i);
        final RelativeLayout.LayoutParams paramsCapitol =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        capitol.setText("Capitolul " + (currentChapter+1));
        paramsCapitol.addRule(RelativeLayout.ALIGN_START, (i-1));
        paramsCapitol.addRule(RelativeLayout.ALIGN_TOP, (i-1));
        capitol.setTextColor(Color.parseColor("#000000"));
        capitol.setTextSize(17);
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.dosis);
        capitol.setTypeface(typeface);
        paramsCapitol.setMargins(15, 15, 0, 0);
        capitol.setLayoutParams(paramsCapitol);
        layout.addView(capitol, paramsCapitol);


        final TextView title = new TextView(getContext());
        titleArrayActually[currentChapter] = title;
        title.setId(++i);
        final RelativeLayout.LayoutParams paramsTitle =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        title.setText(titleArray[currentChapter]);
        paramsTitle.addRule(RelativeLayout.BELOW, (i-1));
        paramsTitle.addRule(RelativeLayout.ALIGN_START, (i-2));
        title.setTextColor(Color.parseColor("#000000"));
        title.setTextSize(28);
        title.setTypeface(typeface);
        paramsTitle.setMargins(45, 0, 0, 0);
        title.setLayoutParams(paramsTitle);
        layout.addView(title, paramsTitle);


        final TextView pages = new TextView(getContext());
        pagesArrayActually[currentChapter] = pages;
        pages.setId(++i);
        final RelativeLayout.LayoutParams paramsPages =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        pages.setText(pagesArray[currentChapter] + " pagini");
        paramsPages.addRule(RelativeLayout.ALIGN_BOTTOM, (i-3));
        paramsPages.addRule(RelativeLayout.ALIGN_END, (i-3));
        pages.setTextColor(Color.parseColor("#000000"));
        pages.setTextSize(15);
        pages.setTypeface(typeface);
        paramsPages.setMargins(0, 0, 15, 10);
        pages.setLayoutParams(paramsPages);
        layout.addView(pages, paramsPages);

        currentChapter++;
        i++;
    }

    public void fillTheArraysFromRes()
    {
        Resources res = getResources();
        titleArray = res.getStringArray(R.array.titlesArrayRes);
        pagesArray = res.getStringArray(R.array.pagesArrayRes);
        nrChapters = res.getInteger(R.integer.chaptersCount);
        nrOfAttributes = res.getInteger(R.integer.nrOfAttributes);
    }

    public void openLearnActivity(int chapterCurrentForFunction)
    {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHAPTER, String.valueOf(chapterCurrentForFunction));
        editor.putString(PAGE, String.valueOf(0));
        editor.apply();
        Intent intent = new Intent(getActivity(), LearnActivity1.class);
        startActivity(intent);
    }

    public void setThemeFunction()
    {
        if(theme == true)
        {
            learnText.setTextColor(Color.parseColor("#FFFFFF"));
            for(int t = 0; t < nrChapters; t++)
            {
                buttonsArray[t].setBackgroundResource(R.drawable.style_bg_dark_ripple);
                titleArrayActually[t].setTextColor(Color.parseColor("#FFFFFF"));
                capitolArrayActually[t].setTextColor(Color.parseColor("#FFFFFF"));
                pagesArrayActually[t].setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
    }
}
