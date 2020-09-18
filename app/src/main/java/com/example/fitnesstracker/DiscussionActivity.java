package com.example.fitnesstracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DiscussionActivity extends AppCompatActivity {

    private ListView discuss;
    private EditText textmessage;
    private Button send_button;

    private DatabaseReference databaseReference;

    String userName;
    String selectedTopic;
    String user_name_key;

    ArrayList<String>listConversion=new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        discuss=(ListView)findViewById(R.id.discussion_listview);
        textmessage=(EditText)findViewById(R.id.message_edit_text);
        send_button=(Button)findViewById(R.id.message_send_button);

        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listConversion);
        discuss.setAdapter(arrayAdapter);

        userName=getIntent().getExtras().get("user_name").toString();
        selectedTopic=getIntent().getExtras().get("selected_topic").toString();
        setTitle("Topic : "+selectedTopic);

        databaseReference= FirebaseDatabase.getInstance().getReference().child(selectedTopic);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                updateConversion(snapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                updateConversion(snapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

    public void send_Option(View view) {

        Map<String,Object>map=new HashMap<String, Object>();
        user_name_key=databaseReference.push().getKey();
        databaseReference.updateChildren(map);

        DatabaseReference databaseReference2=databaseReference.child(user_name_key);
        Map<String,Object>map2=new HashMap<String, Object>();
        map2.put("msg",textmessage.getText().toString());
        map2.put("user",userName);
        databaseReference2.updateChildren(map2);

        textmessage.setText("");

    }

    private void updateConversion(DataSnapshot snapshot) {

        String msg,user,conversation;
        Iterator i=snapshot.getChildren().iterator();
        while(i.hasNext())
        {
            msg=(String)((DataSnapshot)i.next()).getValue();
            user=(String)((DataSnapshot)i.next()).getValue();

            conversation=user+": "+msg;
            arrayAdapter.insert(conversation,arrayAdapter.getCount());
            arrayAdapter.notifyDataSetChanged();

        }

    }


}
