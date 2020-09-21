package com.example.fitnesstracker;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecodListActivity extends AppCompatActivity {


    private ListView listView;
    private List<PersonInfo> personInfoList;
    private SampleAdapter sampleAdapter;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recod_list);

        databaseReference= FirebaseDatabase.getInstance().getReference("PersonsInfo");
        personInfoList=new ArrayList<>();
        sampleAdapter=new SampleAdapter(RecodListActivity.this,personInfoList);
        listView=(ListView)findViewById(R.id.listview);

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                personInfoList.clear();
                for(DataSnapshot dataSnapshot1 : snapshot.getChildren())
                {
                    PersonInfo personInfo=dataSnapshot1.getValue(PersonInfo.class);
                    personInfoList.add(personInfo);
                }

                listView.setAdapter(sampleAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}
