package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIInfo extends AppCompatActivity {

    Button bm_chart;
    TextView bmi_result;
    EditText  foot;
    EditText  inch;
    EditText weight;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_info);

        bm_chart=(Button)findViewById(R.id.bmi_chart);
        foot=(EditText)findViewById(R.id.bmi_foot);
        inch=(EditText)findViewById(R.id.bmi_inch);
        weight=(EditText)findViewById(R.id.bmi_weight);
        cal=(Button)findViewById(R.id.bmi_calculate);
        bmi_result=(TextView)findViewById(R.id.bmi_cal_show);

    }

    public void show_bmichart(View view) {

        Intent i=new Intent(getApplicationContext(),BMi_Chart.class);
        startActivity(i);

    }

    /*private  void display_bmi(float bmi_value)
    {
        String bmi_content;



    }*/

    public void show_bmi_cal(View view) {

        String height_foot=foot.getText().toString();
        String height_inch=inch.getText().toString();
        String weight_kg=weight.getText().toString();
        double inch_me=0.0254;
        double foot_me=0.3048;

        //bmi_result.setText(Double.toString(inch_me));


       if(height_foot!= null && !"".equals(height_foot))
        {
            if(height_inch!=null && !"".equals(height_inch))
            {
                if(weight_kg!=null && !"".equals(weight_kg))
                {
                    float height_inch_value= Float.parseFloat(height_inch)*(float) inch_me;
                    float height_foot_value= Float.parseFloat(height_foot)*(float) foot_me;
                    float final_height=height_foot_value+height_inch_value;
                    float weight_value=Float.parseFloat(weight_kg);
                    float final_res=(weight_value)/(final_height*final_height);
                    //+Float.parseFloat(height_inch)*0.0254;

                    bmi_result.setText(Float.toString(final_res));

                }
            }
        }

    }
}
