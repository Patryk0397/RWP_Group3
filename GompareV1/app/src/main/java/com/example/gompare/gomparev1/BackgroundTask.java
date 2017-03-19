package com.example.gompare.gomparev1;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Patryk on 13/03/2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");
    }
    @Override
    protected String doInBackground(String...params){
        String reg_url = "http://192.168.1.112/register.php";
        String login_url = "http://192.168.1.112/login.php";
        String method = params[0];

        if (method.equals("register")){

            String username = params[1];
            String password = params[2];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("username","UTF-8") +"="+URLEncoder.encode(username, "UTF-8")+"&"+
                URLEncoder.encode("password","UTF-8") +"="+URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                return "Registration Successful";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("login")){

            String loginName = params[1];
            String loginPass = params[2];

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String data = URLEncoder.encode("loginName", "UTF-8")+"="+URLEncoder.encode(loginName, "UTF-8")+"&"+
                    URLEncoder.encode("loginPass", "UTF-8")+"="+URLEncoder.encode(loginPass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){

                    response += line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result){

        if(result.equals("Registration Successful")){

            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        }
        else if(result.equals("Login Successful")) {

            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }

}
