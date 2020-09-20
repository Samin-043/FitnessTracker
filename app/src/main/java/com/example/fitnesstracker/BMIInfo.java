package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class BMIInfo extends AppCompatActivity {

    Button bm_chart;
    TextView bmi_result;
    EditText  foot;
    EditText  inch;
    EditText weight;
    Button cal;
    TextView weight_view;
    TextView weight_view_text;
    TextView health_view;
    TextView health_view_text;
    TextView health_issue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_info);
        this.setTitle("BMI ");

        bm_chart=(Button)findViewById(R.id.bmi_chart);
        foot=(EditText)findViewById(R.id.bmi_foot);
        inch=(EditText)findViewById(R.id.bmi_inch);
        weight=(EditText)findViewById(R.id.bmi_weight);
        cal=(Button)findViewById(R.id.bmi_calculate);
        bmi_result=(TextView)findViewById(R.id.bmi_cal_show);
        weight_view=(TextView)findViewById(R.id.we_catagory);
        weight_view_text=(TextView)findViewById(R.id.we_catagory_text);
        health_view=(TextView)findViewById(R.id.health_tips);
        health_view_text=(TextView)findViewById(R.id.health_text);
        health_issue=(TextView)findViewById(R.id.causes_of_health);

    }

    public void show_bmichart(View view) {

        Intent i=new Intent(getApplicationContext(),BMi_Chart.class);
        startActivity(i);

    }

    private  void display_bmi(float bmi_value)
    {
        String bmi_content="";
        if(bmi_value<18.5)
        {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float twoDigitsF = Float.valueOf(decimalFormat.format(bmi_value));
            bmi_result.setText(twoDigitsF+"");
            weight_view.setText("Weight catagory: ");
            weight_view_text.setText("Underweight");
            health_view.setText("Health Risk: ");
            health_view_text.setText("maximum");
            health_issue.setText("");
            health_issue.setText(getText(R.string.bmi_underweight));
        }
        else if(bmi_value>=18.5&&bmi_value<23)
        {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float twoDigitsF = Float.valueOf(decimalFormat.format(bmi_value));
            bmi_result.setText(twoDigitsF+"");
            weight_view.setText("Weight catagory: ");
            weight_view_text.setText("Normal Range");
            health_view.setText("Health Risk: ");
            health_view_text.setText("low");
            health_issue.setText("");
        }
        else if(bmi_value>=23&&bmi_value<25)
        {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float twoDigitsF = Float.valueOf(decimalFormat.format(bmi_value));
            bmi_result.setText(twoDigitsF+"");
            weight_view.setText("Weight catagory: ");
            weight_view_text.setText("Overweight- At Risk");
            health_view.setText("Health Risk: ");
            health_view_text.setText("high");
            health_issue.setText("");
            health_issue.setText(getText(R.string.bmi_Overweight_at_Risk));
        }
        else if(bmi_value>=25&&bmi_value<30)
        {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float twoDigitsF = Float.valueOf(decimalFormat.format(bmi_value));
            bmi_result.setText(twoDigitsF+"");
            weight_view.setText("Weight catagory: ");
            weight_view_text.setText("Overweight-Moderately Obese");
            health_view.setText("Health Risk: ");
            health_view_text.setText("much high");
            health_issue.setText(getText(R.string.bmi_overweight_moderately_obese));

        }
        else
        {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float twoDigitsF = Float.valueOf(decimalFormat.format(bmi_value));
            bmi_result.setText(twoDigitsF+"");
            weight_view.setText("Weight catagory: ");
            weight_view_text.setText("Overweight-Severely Obese");
            health_view.setText("Health Risk: ");
            health_view_text.setText("maximum high");
            health_issue.setText("");
            health_issue.setText(getText(R.string.bmi_overweight_severely_obese));

        }
    }

    public void show_bmi_cal(View view) {

        String height_foot=foot.getText().toString();
        String height_inch=inch.getText().toString();
        String weight_kg=weight.getText().toString();
        double inch_me=0.0254;
        double foot_me=0.3048;


        int flag=0;

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

                    //bmi_result.setText(Float.toString(final_res));
                    flag=1;

                    display_bmi(final_res);

                    if(flag==1)
                    {
                        foot.setText("");
                        inch.setText("");
                        weight.setText("");
                    }

                }
            }
        }
    }
}
