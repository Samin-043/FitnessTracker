package com.example.fitnesstracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SampleAdapter extends ArrayAdapter<PersonInfo> {

    private Activity context;
    private List<PersonInfo> personInfoList;

    public SampleAdapter(Activity context, List<PersonInfo> personInfoList) {
        super(context, R.layout.sample, personInfoList);
        this.context = context;
        this.personInfoList = personInfoList;

    }

    @NonNull
    @Override
    public View getView(int position,View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample,null,true);

         PersonInfo personInfo=personInfoList.get(position);

        TextView t1=view.findViewById(R.id.gender_textview);
        TextView t2=view.findViewById(R.id.name_textview);
        TextView t3=view.findViewById(R.id.height_textview);
        TextView t4=view.findViewById(R.id.weight_textview);

        t1.setText("Gender : "+personInfo.getGender());
        t2.setText("Name : "+personInfo.getName());
        t3.setText("Height : "+personInfo.getHeight());
        t4.setText("Weight : "+personInfo.getWeight());

        return view;

    }
}
