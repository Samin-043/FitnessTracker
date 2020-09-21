package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Yoga_Ashtanga extends AppCompatActivity {

    WebView ashtanga_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga__ashtanga);

        ashtanga_view = findViewById(R.id.gif_ashtanga);
        WebSettings webSettings=ashtanga_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/ashtanga.gif";
        ashtanga_view.loadUrl(file);
    }
}
