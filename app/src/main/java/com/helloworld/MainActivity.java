package com.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MONDAY_CLASS", "onCreate() is called");
        Button btn = findViewById(R.id.btnActivityStarter);
        btn.setOnClickListener(this);
        Button movieBtn = findViewById(R.id.movie);
        movieBtn.setOnClickListener(this);

        /*6th August, 2019 about edit text*/
        Button btnETActivity = findViewById(R.id.btn_et_activity);
        btnETActivity.setOnClickListener(this);

        Button btnRv = findViewById(R.id.btn_rv_activity);
        btnRv.setOnClickListener(this);

        Button btnLifecycle = findViewById(R.id.btnLifeCycle);

        btnLifecycle.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MONDAY_CLASS", "onStart() is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MONDAY_CLASS", "onStop() is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MONDAY_CLASS", "onPause() is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MONDAY_CLASS", "onResume() is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MONDAY_CLASS", "onDestroy() is called");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("MONDAY_CLASS", "onBackPressed() is called");
    }

    @Override
    public void onClick(View v) {
        Log.d("MONDAY_CLASS", "onClick() of button is called");
        switch (v.getId()) {
            case R.id.movie:
                startActivity(new Intent(this, DrawableActivity.class));
                break;
            case R.id.btnActivityStarter:
                Intent intent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "junaid");
                bundle.putString("location", "lahore");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.btn_et_activity:
//6th August, 2019 about edit text

                startActivity(new Intent(this, EditTextActivity.class));
                break;
            case R.id.btn_rv_activity:
                startActivity(new Intent(this, ListActivity.class));
                break;
            case R.id.btnLifeCycle:
                Intent lifeCycleIntent = new Intent(this, LifeCycleActivity.class);
                startActivity(lifeCycleIntent);
                break;
        }

    }
}
