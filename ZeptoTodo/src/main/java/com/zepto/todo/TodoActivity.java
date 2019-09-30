package com.zepto.todo;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TodoActivity extends AppCompatActivity implements View.OnClickListener {

    private TodoDatabase todoDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        todoDB = Room.databaseBuilder(this, TodoDatabase.class, "First_DB").build();
    }

    @Override
    public void onClick(View v) {
        EditText todoText = findViewById(R.id.et_todo);
        if (!todoText.getText().toString().isEmpty()) {
            Todo todo = new Todo(todoText.getText().toString(), false);
            long id = saveTodo(todo);
            if (id > 0) {
                Toast.makeText(this, "todo saved", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "todo not saved. Please try again.", Toast.LENGTH_LONG).show();
            }
//            Intent data = new Intent();
//            data.putExtra("todo", todoText.getText().toString());
//            setResult(Activity.RESULT_OK, data);
//            finish();
        } else {
            Toast.makeText(this, "Please Enter Todo description", Toast.LENGTH_SHORT).show();
        }
    }

    private long saveTodo(Todo todo) {
        return todoDB.getTodoDao().insertTodo(todo);
    }
}
