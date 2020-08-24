package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class ExJogging extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_jogging);
        webView=(WebView)findViewById(R.id.gif_jogging);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/jogging_runner.gif";
        webView.loadUrl(file);

    }


}
