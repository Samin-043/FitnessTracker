package com.example.fitnesstracker;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExPushup extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_pushup);
        this.setTitle("PushUp");

        webView=(WebView)findViewById(R.id.view_pushup);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/hello_pushup.gif";
        webView.loadUrl(file);

    }

}
