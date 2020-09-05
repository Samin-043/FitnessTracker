package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button signIn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn=(Button)findViewById(R.id.SignIn);
        textView=(TextView)findViewById(R.id.AppName);

    }

    public void main2activity_show(View view) {
        Intent i=new Intent(getApplicationContext(),LogInPageActivity.class);
        startActivity(i);
    }
}
