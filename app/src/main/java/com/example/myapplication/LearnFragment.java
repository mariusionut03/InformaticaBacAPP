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
    public String[] badges1Array = new String[20];
    public String[] badges2Array = new String[20];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);

        layout = view.findViewById(R.id.layoutId);
        i = 1; currentChapter = 0;

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
        chapterString = sharedPreferences.getString(CHAPTER, "0");
        pageString = sharedPreferences.getString(PAGE, "0");
        chapter = Integer.parseInt(chapterString);
        page = Integer.parseInt(pageString);

        fillTheArraysFromRes();
        createTextViews();
        return view;
    }

    public void createTextViews()
    {
        final TextView btn = new TextView(getContext());
        btn.setId(i);
        final RelativeLayout.LayoutParams paramsBtn =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        if(i == 1)
            paramsBtn.addRule(RelativeLayout.BELOW, R.id.learnTitle);
        else {
            paramsBtn.addRule(RelativeLayout.BELOW, (i-nrOfAttributes));
        }
        paramsBtn.setMargins(30, 65, 30, 0);
        btn.setLayoutParams(paramsBtn);
        btn.setHeight(350);
        btn.setBackgroundResource(R.drawable.style_bg_light_ripple);
        layout.addView(btn, paramsBtn);


        final TextView capitol = new TextView(getContext());
        capitol.setId(++i);
        final RelativeLayout.LayoutParams paramsCapitol =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        capitol.setText("Capitolul " + (currentChapter+1));
        paramsCapitol.addRule(RelativeLayout.ALIGN_START, (i-1));
        paramsCapitol.addRule(RelativeLayout.ALIGN_TOP, (i-1));
        capitol.setTextColor(Color.parseColor("#000000"));
        capitol.setTextSize(18);
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.dosis);
        capitol.setTypeface(typeface);
        paramsCapitol.setMargins(15, 15, 0, 0);
        capitol.setLayoutParams(paramsCapitol);
        layout.addView(capitol, paramsCapitol);


        final TextView title = new TextView(getContext());
        title.setId(++i);
        final RelativeLayout.LayoutParams paramsTitle =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        title.setText(titleArray[currentChapter]);
        paramsTitle.addRule(RelativeLayout.BELOW, (i-1));
        paramsTitle.addRule(RelativeLayout.ALIGN_START, (i-2));
        title.setTextColor(Color.parseColor("#000000"));
        title.setTextSize(32);
        title.setTypeface(typeface);
        paramsTitle.setMargins(45, 0, 0, 0);
        title.setLayoutParams(paramsTitle);
        layout.addView(title, paramsTitle);


        final TextView pages = new TextView(getContext());
        pages.setId(++i);
        final RelativeLayout.LayoutParams paramsPages =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        pages.setText(pagesArray[currentChapter] + " pagini");
        paramsPages.addRule(RelativeLayout.ALIGN_BOTTOM, (i-3));
        paramsPages.addRule(RelativeLayout.ALIGN_END, (i-3));
        pages.setTextColor(Color.parseColor("#000000"));
        pages.setTextSize(18);
        pages.setTypeface(typeface);
        paramsPages.setMargins(0, 0, 10, 6);
        pages.setLayoutParams(paramsPages);
        layout.addView(pages, paramsPages);

        /*
            <TextView
        android:id="@+id/badge11"
        android:text="C++"
        style="@style/badgeStyle"
        android:layout_alignBottom="@+id/pages1"
        android:layout_toStartOf="@+id/badge12"/>


        x<item name="android:background">#838383</item>
        x<item name="android:layout_marginEnd">5dp</item>
        x<item name="android:textColor">#000000</item>
        x<item name="android:textSize">9dp</item>
        x<item name="android:padding">2dp</item>
         */

        final TextView badge1 = new TextView(getContext());
        badge1.setId(++i);
        final RelativeLayout.LayoutParams paramsBadge1 =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        badge1.setText(badges1Array[currentChapter]);
        paramsBadge1.addRule(RelativeLayout.ALIGN_BOTTOM, (i-1));
        paramsBadge1.addRule(RelativeLayout.START_OF, (i-1));
        badge1.setTextColor(Color.parseColor("#FFFFFF"));
        badge1.setBackgroundColor(Color.parseColor("#000000"));
        badge1.setTextSize(10);
        badge1.setTypeface(typeface);
        badge1.setPadding(4, 4, 4, 4);
        paramsBadge1.setMargins(0, 0, 10, 0);
        badge1.setLayoutParams(paramsBadge1);
        if(badges1Array[currentChapter] != "-")
            layout.addView(badge1, paramsBadge1);

        /*

    <TextView
        android:id="@+id/badge12"
        android:text="M1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        style="@style/badgeStyle"
        android:layout_alignBottom="@+id/badge11"
        android:layout_toStartOf="@+id/pages1"/>

         */

        final TextView badge2 = new TextView(getContext());
        badge2.setId(++i);
        final RelativeLayout.LayoutParams paramsBadge2 =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        badge2.setText(badges2Array[currentChapter]);
        paramsBadge2.addRule(RelativeLayout.ALIGN_BOTTOM, (i-2));
        paramsBadge2.addRule(RelativeLayout.START_OF, (i-1));
        badge2.setTextColor(Color.parseColor("#FFFFFF"));
        badge2.setBackgroundColor(Color.parseColor("#000000"));
        badge2.setTextSize(10);
        badge2.setTypeface(typeface);
        badge2.setPadding(4, 4, 4, 4);
        paramsBadge2.setMargins(0, 0, 10, 0);
        badge2.setLayoutParams(paramsBadge2);
        if(badges2Array[currentChapter] != "-")
            layout.addView(badge2, paramsBadge2);
    }

    public void btnclicklistener()
    {
        chapter = 0; page = 0;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHAPTER, String.valueOf(chapter));
        editor.putString(PAGE, String.valueOf(page));
        editor.apply();
        Intent intent = new Intent(getActivity(), LearnActivity1.class);
        startActivity(intent);
    }

    public void fillTheArraysFromRes()
    {
        Resources res = getResources();
        titleArray = res.getStringArray(R.array.titlesArrayRes);
        pagesArray = res.getStringArray(R.array.pagesArrayRes);
        badges1Array = res.getStringArray(R.array.badges1ArrayRes);
        badges2Array = res.getStringArray(R.array.badges2ArrayRes);
        nrChapters = res.getInteger(R.integer.chaptersCount);
        nrOfAttributes = res.getInteger(R.integer.nrOfAttributes);
    }
}
