package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserTypeActivity extends AppCompatActivity {
    private Button register, update;
    SharedPreferences myPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        register = findViewById(R.id.register);
        update = findViewById(R.id.update);
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserTypeActivity.this,MainActivity.class));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserTypeActivity.this,UpdateUserAuthActivity.class));
            }
        });
    }
}