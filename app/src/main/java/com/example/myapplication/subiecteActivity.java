package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class subiecteActivity extends AppCompatActivity {

    public TextView textView;
    public String valoareatransmisa;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    public static final String REFRESH = "refreshTheme";
    public static final String SUBIECT = "numarSubiect";
    private boolean theme;
    public RelativeLayout layoutId;
    public Button exitButton;
    public PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subiecte);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
        layoutId = findViewById(R.id.layoutId);

        valoareatransmisa = sharedPreferences.getString(SUBIECT, "1");


        exitButton = findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(v -> goBackToMain());

        PDFView pdfView = findViewById(R.id.pdfview);
        if(valoareatransmisa.equals("1"))
            pdfView.fromAsset("mi2022.pdf").load();
        else if(valoareatransmisa.equals("2"))
            pdfView.fromAsset("mi2021.pdf").load();
        else if(valoareatransmisa.equals("3"))
            pdfView.fromAsset("mi2020.pdf").load();
        else if(valoareatransmisa.equals("4"))
            pdfView.fromAsset("mi2019.pdf").load();
        else if(valoareatransmisa.equals("5"))
            pdfView.fromAsset("mi2018.pdf").load();
        else if(valoareatransmisa.equals("6"))
            pdfView.fromAsset("mi2017.pdf").load();
        else if(valoareatransmisa.equals("7"))
            pdfView.fromAsset("mi2016.pdf").load();
        else if(valoareatransmisa.equals("8"))
            pdfView.fromAsset("mi2015.pdf").load();
        else if(valoareatransmisa.equals("9"))
            pdfView.fromAsset("mi2014.pdf").load();
        else if(valoareatransmisa.equals("10"))
            pdfView.fromAsset("mi2013.pdf").load();
        else if(valoareatransmisa.equals("11"))
            pdfView.fromAsset("mi2012.pdf").load();
        else
            pdfView.fromAsset("mi2022.pdf").load();

        functionTema();
    }

    public void goBackToMain()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(REFRESH, true);
        editor.apply();
        finish();
    }

    public void functionTema()
    {
        if(theme == true)
        {
            layoutId.setBackgroundColor(Color.parseColor("#000c2e"));
        }
        else
        {
            layoutId.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }
}