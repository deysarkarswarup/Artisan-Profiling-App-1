package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.material.textfield.TextInputLayout;

public class ExperienceActivity extends AppCompatActivity {
    TextInputLayout experience;
    EditText nam;//to show error msg
    Button submitbtn;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String ExperienceHolder;
    SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    RadioGroup radioGroup;
    String yesOrNo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        experience = (TextInputLayout)findViewById(R.id.experi);
        nam = (EditText)findViewById(R.id.nam);//to show error msg
        submitbtn = (Button)findViewById(R.id.submitBtn);
        mediaPlayer = MediaPlayer.create(this, R.raw.phoneno);
        mediaPlayer.start();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.yes:
                        yesOrNo = "হ্যাঁ";
                        Log.d("eirki yesorno stor->",yesOrNo);
                        //Toast.makeText(getApplicationContext(),"you selected yes", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.no:
                        yesOrNo = "না";
                        Log.d("eirki yesorno stor->",yesOrNo);
                        //Toast.makeText(getApplicationContext(),"you selected no", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            });

            //Initialize of SharedPref
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(ExperienceActivity.this);
        progressDialog = new ProgressDialog(ExperienceActivity.this);



        submitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!nam.getText().toString().equals("")){
                    //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
                    regUser();
                    Intent i=new Intent(ExperienceActivity.this,ImageCaptureSelection.class);
                    startActivity(i);
                }
                else{
                    nam.setError("আপনার অভিজ্ঞতা টাইপ করুন");
                }
            }

            private void regUser() {
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                ExperienceHolder = experience.getEditText().getText().toString().trim();
                Log.d("eirki",ExperienceHolder);
                //myPref.edit().putString("phone", PhoneNoHolder).apply();
//                String dataToGet = myPref.getString("phone","No data found");
                String idToGet = myPref.getString("id","No data found");
                String artformToGet = myPref.getString("artform","No data found");
                Log.d("eirki id->",idToGet);
                Log.d("eirki artform->",artformToGet);
                Log.d("eirki ha or na->",yesOrNo);

                String myurl = "http://192.168.43.12/Artisans-Profiling/experience.php?experience=" + ExperienceHolder
                       +"&orgmember="+ yesOrNo +"&id="+idToGet +"&artform="+artformToGet ;

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, myurl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing response message coming from server.
                                Toast.makeText(ExperienceActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                                myPref.edit().putString("track", "8").apply();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing error message if something goes wrong.
                                Toast.makeText(ExperienceActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                queue.add(stringRequest);

            }

        });

    }

}