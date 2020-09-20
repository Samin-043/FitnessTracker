package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExecirseInfo extends AppCompatActivity {

    Button jumping_jack;
    Button push_up;
    Button crunch;
    Button mountain_climber;
    Button joging;
    Button lunge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execirse_info);
        this.setTitle("ExecirseInfo");

        jumping_jack=(Button)findViewById(R.id.Jumping_jack);
        push_up=(Button)findViewById(R.id.Push_up);
        crunch=(Button)findViewById(R.id.Chrunch);
        mountain_climber=(Button)findViewById(R.id.Mountaing_climb);
        joging=(Button)findViewById(R.id.jogging);
        lunge=(Button)findViewById(R.id.lunge_exe);

    }


    public void show_jumping_jacks(View view) {
        Intent i=new Intent(getApplicationContext(), ExJumping_jack.class);
        startActivity(i);
    }

    public void PushUp_show(View view) {
        Intent i=new Intent(getApplicationContext(), ExPushup.class);
        startActivity(i);

    }

    public void mountain_climb_show(View view) {
        Intent i=new Intent(getApplicationContext(), ExMountainclimber.class);
        startActivity(i);
    }

    public void chrunch_show(View view) {
        Intent i=new Intent(getApplicationContext(),ExCrunch.class);
        startActivity(i);
    }

    public void jogging_show(View view) {
        Intent i=new Intent(getApplicationContext(), ExJogging.class);
        startActivity(i);
    }

    public void lunge_show(View view) {
        Intent i=new Intent(getApplicationContext(), ExLunge.class);
        startActivity(i);
    }


    public void EXE_previous_page_show(View view) {
        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
    }



}
