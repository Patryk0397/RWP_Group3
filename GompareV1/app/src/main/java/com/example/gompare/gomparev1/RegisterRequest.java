package com.example.gompare.gomparev1;

/**
 * Created by Admin on 05/03/2017.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL = "https://gompare.000webhostapp.com/Register.php";

    // We need to create a Map
    private Map<String, String>params;

    // We need to create a constructor for this class which is the first method that runs
    public RegisterRequest(String username, String password, Response.Listener<String> listener){

        // We need to give Volley a method.
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        // we need to create the param
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

    }
    // The code above has put all the data into Params, but noew Volley needs to access that data.
    // We did that using get param


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
