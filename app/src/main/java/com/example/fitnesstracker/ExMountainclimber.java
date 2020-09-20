package com.example.fitnesstracker;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExMountainclimber extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Mountain Climber");

        setContentView(R.layout.activity_exe_mountainclimber);
        webView=(WebView)findViewById(R.id.mountain_climb);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/new_Mountain Climbers.gif";
        webView.loadUrl(file);

    }

}
