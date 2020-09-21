package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YogaInfo extends AppCompatActivity {

    Button Vinyasa;
    Button Ashtanga;
    Button Iyengar;
    Button Yin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_info);

        Vinyasa = findViewById(R.id.Vinyasa);
        Ashtanga = findViewById(R.id.Ashtanga);
        Iyengar = findViewById(R.id.Iyengar);
        Yin = findViewById(R.id.Yin);


    }

    public void vinyasa_show(View view) {
        Intent intent = new Intent(getApplicationContext(),Yoga_Vinyasa.class);
        startActivity(intent);
    }

    public void ashtanga_show(View view) {
        Intent intent = new Intent(getApplicationContext(),Yoga_Ashtanga.class);
        startActivity(intent);
    }


    public void iyengar_show(View view) {
        Intent intent = new Intent(getApplicationContext(),Yoga_Iyengar.class);
        startActivity(intent);
    }

    public void yin_show(View view) {
        Intent intent = new Intent(getApplicationContext(),Yoga_Yin.class);
        startActivity(intent);
    }
}
