package com.example.sorin.gompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              Intent startActivityIntent = new Intent(getApplicationContext(),SplashScreen.class);
                startActivity(startActivityIntent);
            }
        });

    }
}
