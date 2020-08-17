package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Insert_image_instructionActivity extends AppCompatActivity {
    Button submitbtn;
    private static final int PERMISSION_REQUEST_CODE = 100;
    SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    private ImageView img1,img2,img3,img4;
    private String selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_image_instruction);
        submitbtn = (Button)findViewById(R.id.submitBtn);
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        mediaPlayer = MediaPlayer.create(this, R.raw.phoneno);
        selected = myPref.getString("selected","none");
        try {
            switch (selected) {
                case "saree":
                    img1.setImageResource(R.drawable.saree1);
                    img2.setImageResource(R.drawable.saree2);
                    img3.setImageResource(R.drawable.saree3);
                    img4.setVisibility(View.GONE);
                    break;
                case "kurta":
                    img1.setImageResource(R.drawable.kurta1);
                    img2.setImageResource(R.drawable.kurta2);
                    img3.setImageResource(R.drawable.kurta3);
                    img4.setImageResource(R.drawable.kurta4);
                    break;
                case "tshirt":
                    img1.setImageResource(R.drawable.tshirt1);
                    img2.setImageResource(R.drawable.tshirt2);
                    img3.setVisibility(View.GONE);
                    img4.setVisibility(View.GONE);
                    break;
                case "showpiece":
                    img1.setImageResource(R.drawable.showpiece1);
                    img2.setImageResource(R.drawable.showpiece2);
                    img3.setImageResource(R.drawable.showpiece3);
                    img4.setImageResource(R.drawable.showpiece4);
                    break;
                case "bag":
                    img1.setImageResource(R.drawable.bag1);
                    img2.setImageResource(R.drawable.bag2);
                    img3.setImageResource(R.drawable.bag3);
                    img4.setVisibility(View.GONE);
                    break;
                case "goina":
                    img1.setImageResource(R.drawable.goina1);
                    img2.setImageResource(R.drawable.goina2);
                    img3.setImageResource(R.drawable.goina3);
                    img4.setVisibility(View.GONE);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Some Error Occured!", Toast.LENGTH_LONG).show();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!checkPermission()) {

                    requestPermission();
                }
                else{
                    mediaPlayer.start();
                }
            }
        }

        String SelectedType = myPref.getString("selected","No data found");
        if(SelectedType=="saree"){

        }


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Insert_image_instructionActivity.this, CaptureImageActivity.class);
                startActivity(i);


            }


            });
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(Insert_image_instructionActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //int result2 = ContextCompat.checkSelfPermission(Insert_image_instructionActivity.this, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED ) {
            return true;
        } else {
            return false;
        }
    }


//    private void requestPermission() {
//        int i=0;
//        if (ActivityCompat.shouldShowRequestPermissionRationale(Insert_image_instructionActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//            i=1;
//            Toast.makeText(Insert_image_instructionActivity.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
//        }
////        if(ActivityCompat.shouldShowRequestPermissionRationale(Insert_image_instructionActivity.this, android.Manifest.permission.CAMERA)) {
////            i=2;
////            Toast.makeText(Insert_image_instructionActivity.this, "Camera permission allows us to Click Pictures. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
////        }
//
//
//        else {
//            i=3;
//            ActivityCompat.requestPermissions(Insert_image_instructionActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
////            ActivityCompat.requestPermissions(Insert_image_instructionActivity.this, new String[]{android.Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
//        }
//        Log.d("check",Integer.toString(i));
////        Intent ii = new Intent(Insert_image_instructionActivity.this, CaptureImageActivity.class);
////        startActivity(ii);
//    }

    private void requestPermission() {
        int i=0;
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//            i=1;
//            Toast.makeText(this, "Camera permission allows us to click images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
//        }
//
//
//
//        else {
//            i=3;
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//
//        }

        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("Permission is needed to access files from your device...")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Insert_image_instructionActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},666);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},666);
        }
        Log.d("check",Integer.toString(i));
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    myPref.edit().putString("track", "6").apply();
//                    Log.e("value", "Permission Granted, Now you can use local drive .");
//                    Intent i = new Intent(Insert_image_instructionActivity.this, CaptureImageActivity.class);
//                    startActivity(i);
//                } else {
//                    Log.e("value", "Permission Denied, You cannot use local drive .");
//                }
//                break;
////            case 9:
////                if (grantResults.length > 1 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
////                    Log.e("value", "Permission Granted, Now you can use camera .");
////                } else {
////                    Log.e("value", "Permission Denied, You cannot use camera.");
////                }
////                break;
//        }
        switch (requestCode) {

            case 666: // Allowed was selected so Permission granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d("Jhingalala", "granted");
                    mediaPlayer.start();

                    // do your work here

                } else if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                    // User selected the Never Ask Again Option Change settings in app settings manually
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setTitle("Change Permissions in Settings");
                    alertDialogBuilder
                            .setMessage("" +
                                    "\nClick SETTINGS to Manually Set\n" + "Permissions to use Database Storage")
                            .setCancelable(false)
                            .setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                                    intent.setData(uri);
                                    startActivityForResult(intent, 1000);     // Comment 3.
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                } else {
                    // User selected Deny Dialog to EXIT App ==> OR <== RETRY to have a second chance to Allow Permissions
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setTitle("Second Chance");
                        alertDialogBuilder
                                .setMessage("Click RETRY to Set Permissions to Allow\n\n" + "Click EXIT to the Close App")
                                .setCancelable(false)
                                .setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Integer.parseInt(WRITE_EXTERNAL_STORAGE));
                                        Intent i = new Intent(Insert_image_instructionActivity.this, Insert_image_instructionActivity.class);
                                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(i);
                                    }
                                })
                                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        finishAffinity();
                                        System.exit(0);
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
                break;
        }
    }

}