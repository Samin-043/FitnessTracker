package com.example.fitnesstracker;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExJumping_jack extends AppCompatActivity {

    WebView jumping_jack_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_jumping_jack);
        this.setTitle("Jumping jack");

        jumping_jack_view=(WebView)findViewById(R.id.gif_jumping_jack);
        WebSettings webSettings=jumping_jack_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/jumping_jack.gif";
        jumping_jack_view.loadUrl(file);

    }

}
