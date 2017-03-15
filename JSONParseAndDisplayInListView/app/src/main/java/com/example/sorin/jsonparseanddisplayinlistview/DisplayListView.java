package com.example.sorin.jsonparseanddisplayinlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {


    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;

    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        contactAdapter = new ContactAdapter(this,R.layout.row_layout);
        listView = (ListView) findViewById(R.   id.listView);
        listView.setAdapter(contactAdapter);

        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response"); // server_response (example took from JSON Code, check tutorial
            int count = 0;
            String name, email, mobile;
            while (count <jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(count);
                name = JO.getString("name");
                email = JO.getString("email");
                mobile = JO.getString("mobile");

                Contacts contacts = new Contacts (name, email, mobile);
                contactAdapter.add(contacts);

                count ++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
