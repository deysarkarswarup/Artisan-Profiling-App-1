package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThankYouActivity extends AppCompatActivity {
    Button finish,newentry;
    SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        finish = (Button) findViewById(R.id.finish);
        newentry = (Button) findViewById(R.id.newEntry);
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(this, R.raw.thankyouinst);
        mediaPlayer.start();
        myPref.edit().putString("track","17").apply();
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ThankYouActivity.this.finish();
//                System.exit(0);
                finishAffinity();
                System.exit(0);
            }
        });

        newentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent i=new Intent(ThankYouActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}