package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class ExLunge extends AppCompatActivity {

    WebView lunge_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_lunge);

        lunge_view=(WebView)findViewById(R.id.gif_lunge);
        WebSettings webSettings=lunge_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/lunge.gif";
        lunge_view.loadUrl(file);

    }




}
