package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

public class ArtformActivity3 extends AppCompatActivity {
    TextInputLayout noofcoworkers;
    EditText nam;//to show error msg
    Button submitbtn;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String NOofCoWorkersHolder, yesOrNo="";
    SharedPreferences myPref;
    RadioButton yes, no;
    RadioGroup radioGroup;
    TextView inst;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artform3);

        noofcoworkers = (TextInputLayout)findViewById(R.id.noofcoworker);
        nam = (EditText)findViewById(R.id.nam2);//to show error msg
        submitbtn = (Button)findViewById(R.id.submitBtn);
        //Initialize of SharedPref
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
//        yes = findViewById(R.id.yes);
//        no = findViewById(R.id.no);
        inst = findViewById(R.id.txt);
        mediaPlayer = MediaPlayer.create(this, R.raw.artform3inst);
        mediaPlayer.start();



        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.yes:
                        inst.setVisibility(View.INVISIBLE);
                        noofcoworkers.setVisibility(View.INVISIBLE);
                        submitbtn.setVisibility(View.INVISIBLE);
                        yesOrNo = "হ্যাঁ";
                        Log.d("eirki yesorno stor->",yesOrNo);
                        noreguser();
                        //Toast.makeText(getApplicationContext(),"you selected yes", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.no:
                        inst.setVisibility(View.VISIBLE);
                        noofcoworkers.setVisibility(View.VISIBLE);
                        submitbtn.setVisibility(View.VISIBLE);
                        yesOrNo = "না";
                        Log.d("eirki yesorno stor->",yesOrNo);
                        //Toast.makeText(getApplicationContext(),"you selected no", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            public void noreguser(){
                requestQueue = Volley.newRequestQueue(ArtformActivity3.this);
                progressDialog = new ProgressDialog(ArtformActivity3.this);


                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                NOofCoWorkersHolder = "0";
                String artlearnedToGet = myPref.getString("artlearned","No data found");
                String idToGet = myPref.getString("id","No data found");
                String myurl = "http://192.168.43.12/Artisans-Profiling/artformextras.php?artlearned=" + artlearnedToGet
                        +"&hascoworker="+ yesOrNo +"&noofcoworker="+NOofCoWorkersHolder+"&id="+idToGet;

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, myurl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing response message coming from server.
                                Toast.makeText(ArtformActivity3.this, ServerResponse, Toast.LENGTH_LONG).show();
                                myPref.edit().putString("track", "5").apply();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing error message if something goes wrong.
                                Toast.makeText(ArtformActivity3.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                queue.add(stringRequest);

                Intent i=new Intent(ArtformActivity3.this,ExperienceActivity.class);
                startActivity(i);

            }
        });
        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(ArtformActivity3.this);
        progressDialog = new ProgressDialog(ArtformActivity3.this);
        submitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!nam.getText().toString().equals("")){
                    //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
                    regUser();
//                    NOofCoWorkersHolder = noofcoworkers.getEditText().getText().toString().trim();
  //                  Log.d("eirki Nocoworker stor->",NOofCoWorkersHolder);
//                    myPref.edit().putString("coworker",NOofCoWorkersHolder).apply();
                    myPref.edit().putString("track", "7").apply();
                    Intent i=new Intent(ArtformActivity3.this,ExperienceActivity.class);
                    startActivity(i);
                }
                else{
                    nam.setError("কত জন নিযুক্ত করেছেন?");
                }
            }




        // Creating Volley newRequestQueue .
//        requestQueue = Volley.newRequestQueue(ArtformActivity2.this);
//        progressDialog = new ProgressDialog(ArtformActivity3.this);

//        submitbtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                String y = yes.getText().toString();
//                String x = no.getText().toString();
//
//                if (yes.isChecked()){
//                    inst.setVisibility(View.VISIBLE);
//                    noofcoworkers.setVisibility(View.VISIBLE);
//                }
//                else{
//
//                }



//                boolean checked = ((RadioButton) v).isChecked();
//
//                // Check which radio button was clicked
//                switch(v.getId()) {
//                    case R.id.yes:
//                        if (checked) {
//                            yesOrNo = "হ্যাঁ";
//                            // Pirates are the best
//                            inst.setVisibility(View.VISIBLE);
//                            noofcoworkers.setVisibility(View.VISIBLE);
//
//                            if (!nam.getText().toString().equals("")){
//                                //Toast.makeText(MainActivity.this,"হয়েগেছে",Toast.LENGTH_LONG).show();
//                                regUser();
////                    ArtLearnedHolder = artlearned.getEditText().getText().toString().trim();
////                    myPref.edit().putString("artlearned",ArtLearnedHolder).apply();
//                    Intent i=new Intent(ArtformActivity3.this,ExperienceActivity.class);
//                    startActivity(i);
//                            }
//                            else{
//                                nam.setError("আপনার অভিজ্ঞতা টাইপ করুন");
//                            }
//                        }
//                        break;
//                    case R.id.no:
//                        if (checked)
//                            // Ninjas rule
//                            yesOrNo = "না";
//
//                        regUser();
//                        break;
//                }


//            }

//            public void onYesRadioButtonClicked(View view) {
//                // Is the button now checked?
//
//            }

            private void regUser() {
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                NOofCoWorkersHolder = noofcoworkers.getEditText().getText().toString().trim();
                //Log.d("eirki",NOofCoWorkersHolder);
                //myPref.edit().putString("phone", PhoneNoHolder).apply();
                String artlearnedToGet = myPref.getString("artlearned","No data found");
                String idToGet = myPref.getString("id","No data found");
                //String artformToGet = myPref.getString("artform","No data found");
                Log.d("eirki artlearned->",artlearnedToGet);
                //Log.d("eirki artform->",artformToGet);
                Log.d("eirki hascoworker->",yesOrNo);
                Log.d("eirki No od co-worker->",NOofCoWorkersHolder);

                String myurl = "http://192.168.43.12/Artisans-Profiling/artformextras.php?artlearned=" + artlearnedToGet
                        +"&hascoworker="+ yesOrNo +"&noofcoworker="+NOofCoWorkersHolder+"&id="+idToGet;

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, myurl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing response message coming from server.
                                Toast.makeText(ArtformActivity3.this, ServerResponse, Toast.LENGTH_LONG).show();
                                myPref.edit().putString("track", "5").apply();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();
                                // Showing error message if something goes wrong.
                                Toast.makeText(ArtformActivity3.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                queue.add(stringRequest);

            }

        });

    }
}