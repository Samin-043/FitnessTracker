package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class StepTracker extends AppCompatActivity implements SensorEventListener, StepListener {
    private static final String TEXT_NUM_STEPS = "  Steps";
    private TextView textView;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private int numSteps;
    private TextView TvSteps;
    private SensorEvent event;
    private Button Start;
    private Button Stop;
    private TextView distance;
    private TextView calorie_burn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_tracker);


        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        distance=(TextView)findViewById(R.id.distance_in_km);
        calorie_burn=(TextView)findViewById(R.id.Calorie_Burn);
        //time=(TextView) findViewById(R.id.Time);
        TvSteps = (TextView) findViewById(R.id.tv_steps);
        Start = (Button) findViewById(R.id.start);
        Stop = (Button) findViewById(R.id.stop);


        Start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                numSteps = 0;
                sensorManager.registerListener(StepTracker.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

            }
        });


        Stop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                //Toast.makeText(getApplicationContext(), "Total Number of steps : "+numSteps, Toast.LENGTH_SHORT).show();
                TvSteps.setText("0"+TEXT_NUM_STEPS);
                distance.setText("0 KM");
                calorie_burn.setText("0 CalBurned");
                sensorManager.unregisterListener(StepTracker.this);

            }
        });



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
        double dis=(numSteps*1.0/1250);
        //float f = 102.236569f;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float twoDigitsF = Float.valueOf(decimalFormat.format(dis));
        distance.setText(twoDigitsF+" KM");
        double calorie=numSteps*0.04;
        DecimalFormat decimalFormat1 = new DecimalFormat("#.##");
        float twoDigitsF1 = Float.valueOf(decimalFormat.format(calorie));
        calorie_burn.setText(twoDigitsF1+" CalBurned");

    }

}
