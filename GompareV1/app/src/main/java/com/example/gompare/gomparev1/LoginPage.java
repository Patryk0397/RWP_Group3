package com.example.gompare.gomparev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    EditText ETname, ETpass;
    String loginName, loginPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView RegisterLink = (TextView) findViewById(R.id.RegisterLink);

        ETname = (EditText) findViewById(R.id.loginUsername);
        ETpass = (EditText) findViewById(R.id.loginPassword);

        RegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inteent Opens the Register Activity
                Intent RegisterLink  = new Intent(LoginPage.this, SignUp.class);
                LoginPage.this.startActivity(RegisterLink);
            }
        });

    }

    public void userLogin(View view){

        loginName = ETname.getText().toString();
        loginPass = ETpass.getText().toString();

        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, loginName,loginPass);



    }


}
