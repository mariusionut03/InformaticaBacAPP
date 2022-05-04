package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LearnActivity1 extends AppCompatActivity {

    public Button buttonNext, buttonBack, exitButton;
    public TextView pageCountText;
    public WebView webView;
    public RelativeLayout layoutId;
    public String[][] urlArray = new String[17][9];
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String CHAPTER = "chapter";
    public static final String PAGE = "page";
    public static final String REFRESH = "refreshTheme";
    private boolean theme;
    private String chapterString, pageString;
    private Integer chapter, page, chaptersCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);

        layoutId = findViewById(R.id.layoutId);
        // Load chapter and page with SharedPreferences
        loadDataLearn();

        // URL and pages Data
        Resources res = getResources();
        urlArray[0] = res.getStringArray(R.array.urlChapter1);
        urlArray[1] = res.getStringArray(R.array.urlChapter2);
        urlArray[2] = res.getStringArray(R.array.urlChapter3);
        urlArray[3] = res.getStringArray(R.array.urlChapter4);
        urlArray[4] = res.getStringArray(R.array.urlChapter5);
        urlArray[5] = res.getStringArray(R.array.urlChapter6);
        urlArray[6] = res.getStringArray(R.array.urlChapter7);
        urlArray[7] = res.getStringArray(R.array.urlChapter8);
        urlArray[8] = res.getStringArray(R.array.urlChapter9);
        urlArray[9] = res.getStringArray(R.array.urlChapter10);
        urlArray[10] = res.getStringArray(R.array.urlChapter11);
        urlArray[11] = res.getStringArray(R.array.urlChapter12);
        urlArray[12] = res.getStringArray(R.array.urlChapter13);
        urlArray[13] = res.getStringArray(R.array.urlChapter14);
        urlArray[14] = res.getStringArray(R.array.urlChapter15);
        chaptersCount = res.getInteger(R.integer.chaptersCount);

        // WebView Setup
        webView = findViewById(R.id.webViewHtml);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        loadHtmlPage(urlArray[chapter][page]);

        // Exit Button (Top Left Corner)
        exitButton = findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(v -> goBackToMain());
        // Next page Button
        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(v -> buttonNextFunction());
        // Back page Button
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> buttonBackFunction());
        // Page Count TextView (bottom of the page)
        pageCountText = findViewById(R.id.textViewPageCount);
        setPageCountTextFunction();
        setThemeFunction();
    }

    public void buttonNextFunction() {
        if (page == urlArray[chapter].length - 1 && chapter != chaptersCount - 1) {
            chapter++;
            page = 0;
            saveDataLearn();
            setPageCountTextFunction();
        } else if (page == urlArray[chapter].length - 1 && chapter == chaptersCount - 1) {
            saveDataLearn();
            goBackToMain();
        } else {
            page++;
            saveDataLearn();
            setPageCountTextFunction();
        }
        loadHtmlPage(urlArray[chapter][page]);
    }

    public void buttonBackFunction() {
        if (page == 0 && chapter != 0) {
            chapter--;
            page = urlArray[chapter].length - 1;
            saveDataLearn();
            setPageCountTextFunction();
        } else if (page == 0 && chapter == 0) {
            saveDataLearn();
            goBackToMain();
        } else {
            page--;
            saveDataLearn();
            setPageCountTextFunction();
        }
        loadHtmlPage(urlArray[chapter][page]);
    }

    public void loadDataLearn() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
        chapterString = sharedPreferences.getString(CHAPTER, "0");
        pageString = sharedPreferences.getString(PAGE, "0");
        chapter = Integer.parseInt(chapterString);
        page = Integer.parseInt(pageString);
    }

    public void setThemeFunction() {
        if (theme == false) {
            layoutId.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            layoutId.setBackgroundColor(Color.parseColor("#000000"));
            pageCountText.setTextColor(Color.parseColor("#FFFFFF"));
            buttonNext.setTextColor(Color.parseColor("#FFFFFF"));
            buttonBack.setTextColor(Color.parseColor("#FFFFFF"));
            exitButton.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public void saveDataLearn() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHAPTER, String.valueOf(chapter));
        editor.putString(PAGE, String.valueOf(page));
        editor.apply();
    }

    public void setPageCountTextFunction() {
        String pageCurrentString = String.valueOf(page + 1);
        String chapterCurrentString = String.valueOf(urlArray[chapter].length);
        String textString = pageCurrentString + "/" + chapterCurrentString;
        pageCountText.setText(textString);
    }

    public void loadHtmlPage(String fileAdress)
    {
        InputStream in = null;
        try {
            in = getAssets().open(fileAdress);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        InputStreamReader reader = new InputStreamReader(in);
        try {
            int data = reader.read();
            while (data != -1) {
                char current = (char) data;
                stringBuilder.append(current);
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String htmlBodyFromFile = stringBuilder.toString();

        String cssFileAddress = "file:///android_asset/stylewebview.css";
        if(theme == true)
        {
            cssFileAddress = "file:///android_asset/stylewebviewdark.css";
        }

        String htmlToLoad = "<html>" +
                "<head><link href=\"" + cssFileAddress + "\" rel=\"stylesheet\" type=\"text/css\"></head>" +
                htmlBodyFromFile +
                "</html>";
        webView.loadDataWithBaseURL(null, htmlToLoad, "text/html", "utf-8", null);
    }

    public void goBackToMain()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(REFRESH, true);
        editor.apply();
        finish();
    }
}