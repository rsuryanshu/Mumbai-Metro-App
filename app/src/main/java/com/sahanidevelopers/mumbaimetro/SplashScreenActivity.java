package com.sahanidevelopers.mumbaimetro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

    private static  int splash_time_out = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                                          startActivity(i);

                                          finish();
                                      }
                                  }, splash_time_out
        );
    }
}
