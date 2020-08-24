package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class ExChrunch extends AppCompatActivity {

    WebView webView;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_chrunch);
        webView=(WebView)findViewById(R.id.crunch_view);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/reverse_crunch.gif";
        webView.loadUrl(file);
        previous=(Button)findViewById(R.id.j_previous);

    }


    public void second_previous_page_show(View view) {
        Intent i=new Intent(getApplicationContext(),ExecirseInfo.class);
        startActivity(i);
    }

}
