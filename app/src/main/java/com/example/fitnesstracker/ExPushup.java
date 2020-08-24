package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class ExPushup extends AppCompatActivity {

    WebView webView;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_pushup);

        webView=(WebView)findViewById(R.id.view_pushup);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/hello_pushup.gif";
        webView.loadUrl(file);

        previous=(Button)findViewById(R.id.j_previous);

    }


    public void third_previous_page_show(View view) {

        Intent i=new Intent(getApplicationContext(),ExecirseInfo.class);
        startActivity(i);
    }
}
