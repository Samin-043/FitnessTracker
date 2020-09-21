package com.example.fitnesstracker;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExJogging extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Jogging");

        setContentView(R.layout.activity_exe_jogging);
        webView=(WebView)findViewById(R.id.gif_jogging);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/final_jogging.gif";
        webView.loadUrl(file);

    }


}
