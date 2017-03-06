package com.example.gompare.gomparev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView RegisterLink = (TextView) findViewById(R.id.RegisterLink);

        RegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inteent Opens the Register Activity
                Intent RegisterLink  = new Intent(LoginPage.this, SignUp.class);
                LoginPage.this.startActivity(RegisterLink);
            }
        });
    }
}
