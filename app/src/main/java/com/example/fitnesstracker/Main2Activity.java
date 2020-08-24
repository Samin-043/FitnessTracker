package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button excercise;
    Button food;
    Button heartrate;
    Button dailyroutine;
    Button yoga;
    Button bmi;
    Button chat;
    Button walkingzone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        excercise=(Button) findViewById(R.id.Excercise);
        food=(Button) findViewById(R.id.Food);
        heartrate=(Button) findViewById(R.id.HeartRate);
        dailyroutine=(Button) findViewById(R.id.DailyRoutine);
        yoga=(Button) findViewById(R.id.YogaExcercise);
        bmi=(Button) findViewById(R.id.BmiCal);
        chat=(Button) findViewById(R.id.ChatWithOther);
        walkingzone=(Button) findViewById(R.id.ZoneOfWalking);

    }

    public void Exercise_show(View view) {
        Intent i=new Intent(getApplicationContext(), ExecirseInfo.class);
        startActivity(i);
    }

    public void BMI_page_show(View view) {
        Intent i=new Intent(getApplicationContext(), BMIInfo.class);
        startActivity(i);

    }


    public void diet_show(View view) {
        Intent i=new Intent(getApplicationContext(),DietInfo.class);
        startActivity(i);
    }
}

