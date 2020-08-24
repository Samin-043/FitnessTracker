package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button next;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=(Button)findViewById(R.id.Next);
        textView=(TextView)findViewById(R.id.AppName);

    }

    public void main2activity_show(View view) {
        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
    }
}
