package com.example.fitnesstracker;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class StepTracker extends AppCompatActivity implements SensorEventListener, StepListener {
    private static final String TEXT_NUM_STEPS = "Steps  ";
    private TextView textView;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private TextView TvSteps;
    private SensorEvent event;
    private Button Start;
    private Button Stop;
    private TextView distance;
    private TextView calorie_burn;
    private  TextView time;

    private int numSteps;
    int hour,minute;
    int count;
    double dis;
    double calorie;
    String person_name;
    String person_weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_tracker);
        this.setTitle("Pedometer");


        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        distance=(TextView)findViewById(R.id.distance_in_km);
        calorie_burn=(TextView)findViewById(R.id.Calorie_Burn);
        time=(TextView) findViewById(R.id.Time);
        TvSteps = (TextView) findViewById(R.id.tv_steps);
        Start = (Button) findViewById(R.id.start);
        Stop = (Button) findViewById(R.id.stop);

    }


    public void showStartPedometer(View view) {

        numSteps = 0;
        sensorManager.registerListener(StepTracker.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

    }

    public void ShowEndPedometer(View view) {


        numSteps=0;
        count=0;
        minute=0;
        hour=0;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
        distance.setText("0");
        calorie_burn.setText("0");
        time.setText("0h0m");
        sensorManager.unregisterListener(StepTracker.this);

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {


        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
        dis=(numSteps*1.0/1250);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float twoDigitsF = Float.valueOf(decimalFormat.format(dis));
        distance.setText(twoDigitsF+"");
        calorie=numSteps*0.04;
        count++;
        if(count%2==0)
        {
            DecimalFormat decimalFormat1 = new DecimalFormat("#.#");
            float twoDigitsF1 = Float.valueOf(decimalFormat.format(calorie));
            calorie_burn.setText(twoDigitsF1+"");
            count=0;
        }

        if(numSteps>0&&numSteps%60==0)
        {
            if(numSteps%3600==0)
            {
                minute=numSteps/60;
                hour=numSteps/3600;
                time.setText(hour +"h"+minute+"m  ");

            }
            else
            {
                minute=numSteps/60;
                time.setText(hour+"h"+minute+"m  ");
                //check=true;
            }
        }
        else
        {
            time.setText(hour +"h"+minute+"m  ");
        }

    }

}
