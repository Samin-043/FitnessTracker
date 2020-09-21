package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Yoga_Yin extends AppCompatActivity {

    WebView yin_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga__yin);

        yin_view = findViewById(R.id.gif_yin);
        WebSettings webSettings=yin_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/yin.gif";
        yin_view.loadUrl(file);
    }
}
