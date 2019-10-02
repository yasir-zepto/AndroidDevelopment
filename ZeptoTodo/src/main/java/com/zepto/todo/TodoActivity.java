package com.zepto.todo;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class TodoActivity extends AppCompatActivity implements View.OnClickListener {

    private TodoDatabase todoDB;
    private Todo editTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        todoDB = Room.databaseBuilder(this, TodoDatabase.class, "First_DB").allowMainThreadQueries().build();
        editTodo = (Todo) getIntent().getSerializableExtra("todo");
        if (editTodo != null) {
            EditText todoText = findViewById(R.id.et_todo);
            todoText.setText(editTodo.desc);
            btnSave.setText("Update");
        }
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        EditText todoText = findViewById(R.id.et_todo);
        if (btn.getText().equals("Update")) {
            update(todoText);
        } else {//saves
            saveTodo(todoText);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (editTodo != null) {
            new MenuInflater(getBaseContext()).inflate(R.menu.todo_delete, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_delete) {
            delete();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveTodo(EditText todoText) {
        if (!todoText.getText().toString().isEmpty()) {
            Todo todo = new Todo(todoText.getText().toString(), false);
            long id = todoDB.getTodoDao().insertTodo(todo);
            if (id > 0) {
                Toast.makeText(this, "todo saved", Toast.LENGTH_LONG).show();
                Intent data = new Intent();
                data.putExtra("todo", todoText.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            } else {
                Toast.makeText(this, "todo not saved. Please try again.", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "Please Enter Todo description", Toast.LENGTH_SHORT).show();
        }
    }

    private void update(EditText todoText) {
        if (!todoText.getText().toString().isEmpty()) {
            editTodo.desc = todoText.getText().toString();
            int rows = todoDB.getTodoDao().updateTodo(editTodo);
            if (rows > 0) {

                Toast.makeText(this, "Todo Updated", Toast.LENGTH_SHORT).show();
                Intent data = getIntent();
                data.putExtra("todo", editTodo);
                setResult(Activity.RESULT_OK, data);
                finish();
            } else {
                Toast.makeText(this, "Something went worng. Please try again.", Toast.LENGTH_LONG).show();

            }
        } else {
            Toast.makeText(this, "Please Enter Todo description", Toast.LENGTH_SHORT).show();
        }
    }

    private void delete() {
        int rows = todoDB.getTodoDao().delete(editTodo);
        if (rows > 0) {

            Toast.makeText(this, "Todo Deleted", Toast.LENGTH_SHORT).show();
            Intent data = getIntent();
            data.putExtra("todo", editTodo);
            data.putExtra("isDelete", true);
            setResult(Activity.RESULT_OK, data);
            finish();
        } else {
            Toast.makeText(this, "Something went worng. Please try again.", Toast.LENGTH_LONG).show();
        }
    }
}
