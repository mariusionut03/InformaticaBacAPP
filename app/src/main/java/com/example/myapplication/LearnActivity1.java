package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class LearnActivity1 extends AppCompatActivity {

    public Button buttonNext, buttonBack, exitButton;
    public TextView pageCountText;
    public WebView webView;
    public String[][] urlArray = new String[17][9];
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String CHAPTER = "chapter";
    public static final String PAGE = "page";
    private boolean theme;
    private String chapterString, pageString;
    private Integer chapter, page, chaptersCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);

        // Load chapter and page with SharedPreferences
        loadDataLearn();

        // URL and pages Data
        Resources res = getResources();
        urlArray[0] = res.getStringArray(R.array.urlChapter1);
        urlArray[1] = res.getStringArray(R.array.urlChapter2);
        chaptersCount = res.getInteger(R.integer.chaptersCount);

        // WebView Setup
        webView = findViewById(R.id.webViewHtml);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(urlArray[chapter][page]);

        // Exit Button (Top Left Corner)
        exitButton = findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(v -> finish());
        // Next page Button
        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(v -> buttonNextFunction());
        // Back page Button
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> buttonBackFunction());
        // Page Count TextView (bottom of the page)
        pageCountText = findViewById(R.id.textViewPageCount);
        setPageCountTextFunction();
    }

    public void buttonNextFunction()
    {
        if(page == urlArray[chapter].length - 1 && chapter != chaptersCount-1)
        {
            chapter++;
            page = 0;
            saveDataLearn();
            setPageCountTextFunction();
        }
        else if(page == urlArray[chapter].length - 1 && chapter == chaptersCount-1)
        {
            saveDataLearn();
            finish();
        }
        else
        {
            page++;
            saveDataLearn();
            setPageCountTextFunction();
        }
        webView.loadUrl(urlArray[chapter][page]);
    }

    public void buttonBackFunction()
    {
        if(page == 0 && chapter != 0)
        {
            chapter--;
            page = urlArray[chapter].length - 1;
            saveDataLearn();
            setPageCountTextFunction();
        }
        else if(page == 0 && chapter == 0)
        {
            saveDataLearn();
            finish();
        }
        else
        {
            page--;
            saveDataLearn();
            setPageCountTextFunction();
        }
        webView.loadUrl(urlArray[chapter][page]);
    }

    public void loadDataLearn()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
        chapterString = sharedPreferences.getString(CHAPTER, "0");
        pageString = sharedPreferences.getString(PAGE, "0");
        chapter = Integer.parseInt(chapterString);
        page = Integer.parseInt(pageString);
    }

    public void saveDataLearn()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHAPTER, String.valueOf(chapter));
        editor.putString(PAGE, String.valueOf(page));
        editor.apply();
    }

    public void setPageCountTextFunction()
    {
        String pageCurrentString = String.valueOf(page+1);
        String chapterCurrentString = String.valueOf(urlArray[chapter].length);
        String textString = pageCurrentString + "/" + chapterCurrentString;
        pageCountText.setText(textString);
    }
}