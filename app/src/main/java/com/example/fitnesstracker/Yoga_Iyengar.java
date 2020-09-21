package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Yoga_Iyengar extends AppCompatActivity {

    WebView iyengar_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga__iyengar);

        iyengar_view = findViewById(R.id.gif_iyengar);
        WebSettings webSettings=iyengar_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/iyengar.gif";
        iyengar_view.loadUrl(file);
    }
}
