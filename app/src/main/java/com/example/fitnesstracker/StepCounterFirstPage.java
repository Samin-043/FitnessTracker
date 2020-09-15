package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class StepCounterFirstPage extends AppCompatActivity {

    private Button nextBuxtton;
    private Button recordlist;
    private RadioButton radio_woman;
    private RadioButton radio_man;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter_first_page);

        nextBuxtton = (Button) findViewById(R.id.NextButton);
        recordlist =(Button)findViewById(R.id.Recordlist_button);
        radio_man=(RadioButton)findViewById(R.id.Man_button);
        radio_woman=(RadioButton)findViewById(R.id.Woman_button);

    }

    public void showStepCounter(View view) {
        Intent i=new Intent(getApplicationContext(),StepTracker.class);
        startActivity(i);
    }
}
