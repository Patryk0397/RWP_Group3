package com.example.gompare.gomparev1;

//import android.content.Intent;
//import android.support.v7.app.AlertDialog;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;

//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.Volley;

//import org.json.JSONException;
//import org.json.JSONObject;

//import static com.example.gompare.gomparev1.R.id.enterUsername;

public class SignUp extends Activity {
    String username, password;
    EditText enterUsername, enterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        enterUsername = (EditText) findViewById(R.id.enterUsername);
        enterPassword = (EditText) findViewById(R.id.enterPassword);



    }

    public void userReg(View view){

        username = enterUsername.getText().toString();
        password = enterPassword.getText().toString();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,username,password);
        finish();

    }


}
