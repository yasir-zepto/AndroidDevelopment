package com.zepto.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TodoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText todoText = findViewById(R.id.et_todo);
        if (!todoText.getText().toString().isEmpty()) {
            Intent data = new Intent();
            data.putExtra("todo", todoText.getText().toString());
            setResult(Activity.RESULT_OK, data);
            finish();
        } else {
            Toast.makeText(this, "Please Enter Todo description", Toast.LENGTH_SHORT).show();
        }
    }
}
