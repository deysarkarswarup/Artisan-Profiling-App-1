package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Insert_video_instructionActivity extends AppCompatActivity {
Button submitbtn;
SharedPreferences myPref;
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mediaPlayer = MediaPlayer.create(this, R.raw.phoneno);
        mediaPlayer.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_video_instruction);
        submitbtn = (Button)findViewById(R.id.submitBtn);
        myPref = this.getSharedPreferences("MyPref",MODE_PRIVATE);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("track", "9").apply();
                Intent i=new Intent(Insert_video_instructionActivity.this,CaptureVideoActivity.class);
                startActivity(i);
            }
        });
    }
}