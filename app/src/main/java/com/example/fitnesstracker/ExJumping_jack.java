package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class ExJumping_jack extends AppCompatActivity {

    WebView jumping_jack_view;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe_jumping_jack);

        jumping_jack_view=(WebView)findViewById(R.id.gif_jumping_jack);
        WebSettings webSettings=jumping_jack_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String file = "file:android_asset/jumping_jack.gif";
        jumping_jack_view.loadUrl(file);

        previous=(Button)findViewById(R.id.j_previous);

    }

    public void previous_page_show(View view) {

        Intent i=new Intent(getApplicationContext(),ExecirseInfo.class);
        startActivity(i);

    }
}
