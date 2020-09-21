package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    Button excercise;
    Button food;
    Button dailyroutine;
    Button yoga;
    Button bmi;
    Button chat;
    Button walkingzone;
    Button stepcounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle("Feature");

        excercise=(Button) findViewById(R.id.Excercise);
        food=(Button) findViewById(R.id.Food);
        stepcounter = (Button) findViewById(R.id.Counter_steps);
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

    public void DailyStepsCount(View view) {
        Intent i=new Intent(getApplicationContext(),StepCounterFirstPage.class);
        startActivity(i);
    }

    public void showMessage(View view) {
        Intent i=new Intent(getApplicationContext(),ChatActivity.class);
        startActivity(i);

    }

    public void park_location(View view) {
        Intent i=new Intent(getApplicationContext(),ParkLocation.class);
        startActivity(i);
    }

    public void showDailyRoutine(View view) {
        Intent i=new Intent(getApplicationContext(),DailyRoutineInfo.class);
        startActivity(i);
    }

    public void show_yoga_info(View view) {
        Intent i=new Intent(getApplicationContext(),YogaInfo.class);
        startActivity(i);
    }
}

