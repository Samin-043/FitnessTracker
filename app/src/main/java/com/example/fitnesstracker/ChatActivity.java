package com.example.fitnesstracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.Edits;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatActivity extends AppCompatActivity {

    ListView lvDiscussion;
    ArrayList<String>listOfDiscussion =new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    String UserName;

    private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().getRoot();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        setTitle("Discussion Topic");

        lvDiscussion=(ListView)findViewById(R.id.chat_listview);
        arrayAdapter=new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,listOfDiscussion);

        lvDiscussion.setAdapter(arrayAdapter);

        getUserName();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Set<String>set=new HashSet<String>();
                Iterator i=snapshot.getChildren().iterator();

                while(i.hasNext())
                {
                    set.add(((DataSnapshot)i.next()).getKey());
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(set);
                arrayAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        lvDiscussion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(getApplicationContext(),DiscussionActivity.class);
                in.putExtra("selected_topic",((TextView)view).getText().toString());
                in.putExtra("user_name",UserName);
                startActivity(in);
            }
        });
    }


    private void getUserName()
    {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        final EditText userName=new EditText(this);

        builder.setView(userName);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                UserName=userName.getText().toString();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getUserName();
            }
        });

        builder.show();
    }
}
