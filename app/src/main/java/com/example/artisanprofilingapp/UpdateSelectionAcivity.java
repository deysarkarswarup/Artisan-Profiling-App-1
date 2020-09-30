package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class UpdateSelectionAcivity extends AppCompatActivity {
    Button phoneno, name, age, address, profilePic, artformPicture,experience, silpo, porichitiVideo,artformVideo;
    private SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_selection_acivity);



    }
}