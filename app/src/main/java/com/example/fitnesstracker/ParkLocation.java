package com.example.fitnesstracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ParkLocation extends AppCompatActivity {

    ImageView img_view1;
    ImageView img_view2;
    ImageView img_view3;
    ImageView img_view4;
    Button b1;
    Button b2;
    Button b3;
    Button b4;

    int count=0;
    int gulsan_count=0;
    int hatir_count=0;
    int baridhara_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_location);
        this.setTitle("Nearby Park");

        img_view1=(ImageView)findViewById(R.id.image_view1);
        img_view2=(ImageView)findViewById(R.id.image_view_2);
        img_view3=(ImageView)findViewById(R.id.image_view3);
        img_view4=(ImageView)findViewById(R.id.image_view4);
        b1=(Button)findViewById(R.id.click_image_changer);
        b2=(Button)findViewById(R.id.click_image_changer_1);
        b3=(Button)findViewById(R.id.click_image_changer_2);
        b4=(Button)findViewById(R.id.click_image_changer_3);

    }

    public void show_next_image(View view) {
        count++;
        switch (count)
        {
            case 1:
                img_view1.setImageResource(R.drawable.ramn_pic_1);
                break;
            case 2:
                img_view1.setImageResource(R.drawable.ramn_pic_2);
                break;
            case 3:
                img_view1.setImageResource(R.drawable.ramn_pic_3);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void show_prev_image(View view) {
        count--;
        switch (count)
        {
            case 0:
                img_view1.setImageResource(R.drawable.ramna_pic);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
            case 1:
                img_view1.setImageResource(R.drawable.ramn_pic_1);
                break;
            case 2:
                img_view1.setImageResource(R.drawable.ramn_pic_2);
                break;
        }
    }

    public void show_next_image_1(View view) {

        gulsan_count++;
        switch (gulsan_count)
        {
            case 1:
                img_view2.setImageResource(R.drawable.gulshan_lake_park_1);
                break;
            case 2:
                img_view2.setImageResource(R.drawable.gulshan_lake_park_2);
                break;
            case 3:
                img_view2.setImageResource(R.drawable.gulshan_lake_park_3);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void show_prev_image_1(View view) {

        gulsan_count--;
        switch (gulsan_count) {
            case 0:
                img_view2.setImageResource(R.drawable.gulsan_lake_park_pic);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
            case 1:
                img_view2.setImageResource(R.drawable.gulshan_lake_park_1);
                break;
            case 2:
                img_view2.setImageResource(R.drawable.gulshan_lake_park_2);
                break;
        }
    }


    public void show_next_image2(View view) {

        hatir_count++;
        switch (hatir_count)
        {
            case 1:
                img_view3.setImageResource(R.drawable.hatirjkeel_pic_1);
                break;
            case 2:
                img_view3.setImageResource(R.drawable.hatirjkeel_pic_2);
                break;
            case 3:
                img_view3.setImageResource(R.drawable.hatirjkeel_pic_3);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void show_prev_image2(View view) {

        hatir_count--;
        switch (hatir_count) {
            case 0:
                img_view3.setImageResource(R.drawable.hatirjkeel_pic);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
            case 1:
                img_view3.setImageResource(R.drawable.hatirjkeel_pic_1);
                break;
            case 2:
                img_view3.setImageResource(R.drawable.hatirjkeel_pic_2);
                break;
        }
    }

    public void show_next_image3(View view) {
        baridhara_count++;
        switch (baridhara_count)
        {
            case 1:
                img_view4.setImageResource(R.drawable.baridhara_pic_1);
                break;
            case 2:
                img_view4.setImageResource(R.drawable.baridhara_pic_2);
                break;
            case 3:
                img_view4.setImageResource(R.drawable.baridhara_pic_3);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void show_prev_image3(View view) {
        baridhara_count--;
        switch (baridhara_count) {
            case 0:
                img_view4.setImageResource(R.drawable.baridhara_pic);
                Toast.makeText(getApplicationContext(), "No more Imgaes here...", Toast.LENGTH_LONG).show();
                break;
            case 1:
                img_view4.setImageResource(R.drawable.baridhara_pic_1);
                break;
            case 2:
                img_view4.setImageResource(R.drawable.baridhara_pic_2);
                break;
        }
    }
}
