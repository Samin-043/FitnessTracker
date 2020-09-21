package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class StepCounterFirstPage extends AppCompatActivity {

    private Button nextBuxtton;
    private Button recordlist;
    private RadioButton radio_woman;
    private RadioButton radio_man;
    private Button savebutton;
    private EditText name_person;
    private EditText weight;
    private EditText inch_height;
    private EditText foot_height;

    DatabaseReference databaseReference;

    String gender = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter_first_page);
        this.setTitle("Person Info");


        databaseReference= FirebaseDatabase.getInstance().getReference("PersonsInfo");

        nextBuxtton = (Button) findViewById(R.id.NextButton);
        recordlist =(Button)findViewById(R.id.Recordlist_button);
        radio_man=(RadioButton)findViewById(R.id.Man_button);
        radio_woman=(RadioButton)findViewById(R.id.Woman_button);
        savebutton=(Button)findViewById(R.id.savebutton);
        name_person=(EditText)findViewById(R.id.person_name);
        weight=(EditText)findViewById(R.id.weight_text);
        foot_height=(EditText)findViewById(R.id.height_foot_text);
        inch_height=(EditText)findViewById(R.id.height_inch_text);

    }

    public void showStepCounter(View view) {
        Intent i=new Intent(getApplicationContext(),StepTracker.class);
        startActivity(i);
    }



    public void store_data_front_page(View view) {
        data_save();

        name_person.setText("");
        weight.setText("");
        foot_height.setText("");
        inch_height.setText("");
        radio_man.setChecked(false);
        radio_woman.setChecked(false);

    }


    public void data_save() {

        String height=foot_height.getText().toString().trim()+"ft "+inch_height.getText().toString().trim()+"inch";

        if(radio_man.isChecked()==true)
        {
            gender="man";
        }
        else if(radio_woman.isChecked()==true)
        {
            gender="woman";
        }
        String person_name=name_person.getText().toString().trim();
        String person_weight=weight.getText().toString().trim()+" kg";

        String key=databaseReference.push().getKey();

        PersonInfo person_Info=new PersonInfo(person_name, person_weight, gender, height);

        databaseReference.child(key).setValue(person_Info);
        Toast.makeText(getApplicationContext(), "Persons Info is added", Toast.LENGTH_LONG).show();

    }

    public void showDataFromFirebase(View view) {

        Intent i=new Intent(getApplicationContext(),RecodListActivity.class);
        startActivity(i);

    }
}
