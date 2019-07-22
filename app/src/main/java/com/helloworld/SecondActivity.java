package com.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String location = bundle.getString("location");
            Log.d("MONDAY_CLASS", "name of sender "+ name);
            Log.d("MONDAY_CLASS", "name of location "+ location);
            TextView txtUserDetail = findViewById(R.id.txtUserDetail);
            txtUserDetail.setText(name + " is located in "+ location);
            txtUserDetail.setAllCaps(true);
            txtUserDetail.setTextColor(getResources().getColor(R.color.pink));
        }


    }
}
