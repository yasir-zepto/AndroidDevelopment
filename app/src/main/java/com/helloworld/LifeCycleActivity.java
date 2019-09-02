package com.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LifeCycleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cyclectivity);
        Log.d("lifecyle", "oncreate()");
        //finish();

        Button btnSave = findViewById(R.id.btn_save_note);
        btnSave.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecyle", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecyle", "onPause()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecyle", "onDestroy()");
    }

    @Override
    public void onClick(View v) {
        EditText etNote = findViewById(R.id.et_note);

        String note = etNote.getText().toString();
        Log.d("Note", note);
    }
}
