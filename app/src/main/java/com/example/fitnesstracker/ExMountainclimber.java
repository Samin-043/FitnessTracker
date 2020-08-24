package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class ExMountainclimber extends AppCompatActivity {

    WebView webView;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_mountainclimber);
        webView=(WebView)findViewById(R.id.mountain_climb);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/new_Mountain Climbers.gif";
        webView.loadUrl(file);

        b=(Button)findViewById(R.id.j_previous);

    }

    public void fourth_previous_page_show(View view) {
        Intent i=new Intent(getApplicationContext(),ExecirseInfo.class);
        startActivity(i);

    }
}
