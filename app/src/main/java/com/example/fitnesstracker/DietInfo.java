package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DietInfo extends AppCompatActivity {

    Button calorie;
    Button nutrition;
    Button waterlog;
    Button dailyfood;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_info);

        calorie = findViewById(R.id.calorie);
        nutrition = findViewById(R.id.nutrition);
        waterlog = findViewById(R.id.waterlog);
        dailyfood = findViewById(R.id.dailyfood);

    }


    public void calorieInfo_show(View view) {
        Intent i = new Intent(getApplicationContext(),CalorieInfo.class);
        startActivity(i);
    }

    public void nutritionInfo_show(View view) {
        Intent i = new Intent(getApplicationContext(),NutritionInfo.class);
        startActivity(i);

    }

    public void waterlog_show(View view) {
        Intent i = new Intent(getApplicationContext(),WaterLogInfo.class);
        startActivity(i);
    }

    public void dailyfood_show(View view) {
        Intent i = new Intent(getApplicationContext(),DailyFoodInfo.class);
        startActivity(i);
    }
}
