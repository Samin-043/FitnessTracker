package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Yoga_Vinyasa extends AppCompatActivity {

    WebView vinyasa_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga__vinyasa);

        vinyasa_view = findViewById(R.id.gif_vinyasa);
        WebSettings webSettings=vinyasa_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/vinyasa.gif";
        vinyasa_view.loadUrl(file);
    }
}
