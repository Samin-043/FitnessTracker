package com.example.fitnesstracker;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExLunge extends AppCompatActivity {

    WebView lunge_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_lunge);
        this.setTitle("Lunge");


        lunge_view=(WebView)findViewById(R.id.gif_lunge);
        WebSettings webSettings=lunge_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/lunges_new.gif";
        lunge_view.loadUrl(file);

    }




}
