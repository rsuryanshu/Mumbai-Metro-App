package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    Button emailBtn, callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        emailBtn = findViewById(R.id.emailButton);
        callBtn = findViewById(R.id.callButton);

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mumbaimetroproj@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Mumbai Metro App");
                intent.putExtra(Intent.EXTRA_TEXT,"Your Name and Suggestion: ");
                startActivity(Intent.createChooser(intent, "Send: "));
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23) {
                    phoneCall();
                }else {

                    if (ActivityCompat.checkSelfPermission(ContactActivity.this,
                            android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                        phoneCall();
                    }else {
                        final String[] PERMISSIONS_STORAGE = {android.Manifest.permission.CALL_PHONE};
                        ActivityCompat.requestPermissions(ContactActivity.this, PERMISSIONS_STORAGE, 9);
                    }
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionGranted = false;
        switch(requestCode){
            case 9:
                permissionGranted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                break;
        }
        if(permissionGranted){
            phoneCall();
        }else {
            Toast.makeText(ContactActivity.this, "Permission denied.", Toast.LENGTH_SHORT).show();
        }
    }

    private void phoneCall(){
        if (ActivityCompat.checkSelfPermission(ContactActivity.this,
                android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:7021026058"));
            startActivity(callIntent);
        }else{
            Toast.makeText(ContactActivity.this, "Permission denied.", Toast.LENGTH_SHORT).show();
        }
    }
}
