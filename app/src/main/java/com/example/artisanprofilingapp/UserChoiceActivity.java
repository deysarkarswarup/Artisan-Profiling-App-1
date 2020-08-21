package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserChoiceActivity extends AppCompatActivity {

    Button yes,no;
    SharedPreferences myPref;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
        yes = (Button) findViewById(R.id.yesBtn);
        no = (Button) findViewById(R.id.noBtn);
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(this, R.raw.userchoiceinst);
        mediaPlayer.start();

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i=new Intent(UserChoiceActivity.this,CaptureImageActivity.class);
                startActivity(i);
            }
            });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPref.edit().putString("track","12").apply();
                mediaPlayer.stop();
                Intent i=new Intent(UserChoiceActivity.this,Insert_video_instructionActivity.class);
                startActivity(i);
            }
        });



    }
}
