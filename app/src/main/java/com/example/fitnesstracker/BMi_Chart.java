package com.example.fitnesstracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BMi_Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__chart);
        this.setTitle("BMI Chart");
    }
}
