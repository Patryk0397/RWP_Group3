package com.example.gompare.gomparev1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Used thread to make the splash screen
        // It doesn't generate the override method so right  click and click on generate and use the run void
     Thread myThread = new Thread() {
         // a Thread object myThread is created and initialised.
         @Override
         public void run() {
             // delete super.run() and write sleep
             // click alt and Enter and choose the try anc catch in order to avoid the error.
             // create an intent
             try {
                 sleep(3000);
                 // create an intent
                 Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                 startActivity(intent);
                 // after you need to delete the activity by using finish
                 finish();

             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     } ;

        // call the start method that will call the un method
        // now update the manifest file
        myThread.start();



    }
}
