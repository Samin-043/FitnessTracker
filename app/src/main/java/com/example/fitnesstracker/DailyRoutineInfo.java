package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.fitnesstracker.R.id.listViewId;

public class DailyRoutineInfo extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_routine_info);

        listView = findViewById(listViewId);

        final String[] Weeks = getResources().getStringArray(R.array.weeks);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DailyRoutineInfo.this,R.layout.sample_dailyroutine_info,R.id.textViewId,Weeks);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Intent intent = new Intent(getApplicationContext(),WorkingDay.class);
                    startActivity(intent);
                }
                if(i == 1)
                {
                    Intent intent = new Intent(getApplicationContext(),WorkingDay.class);
                    startActivity(intent);
                }
                if(i == 2)
                {
                    Intent intent = new Intent(getApplicationContext(),WorkingDay.class);
                    startActivity(intent);
                }
                if(i == 3)
                {
                    Intent intent = new Intent(getApplicationContext(),WorkingDay.class);
                    startActivity(intent);
                }
                if(i == 4)
                {
                    Intent intent = new Intent(getApplicationContext(),WorkingDay.class);
                    startActivity(intent);
                }
                if(i == 5)
                {
                    Intent intent = new Intent(getApplicationContext(),WeekendDay.class);
                    startActivity(intent);
                }
                if(i == 6)
                {
                    Intent intent = new Intent(getApplicationContext(),WeekendDay.class);
                    startActivity(intent);
                }
            }
        });
    }
}
