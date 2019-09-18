package com.zepto.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    TodoAdapter adapter = new TodoAdapter();
    private RecyclerView rvTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvTodo = findViewById(R.id.rv_todo);
        adapter.data.add(new Todo("My First dummy Todo", false));
        adapter.data.add(new Todo("Create Todo App", false));
        adapter.data.add(new Todo("Create List View", false));
        adapter.data.add(new Todo("Exercise at 4 pm", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        adapter.data.add(new Todo("Meeting with a friend", false));
        rvTodo.setAdapter(adapter);
        rvTodo.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        FloatingActionButton fab = findViewById(R.id.fab_new_todo);
        fab.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.todo_select, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_select) {
            adapter.enableSelection();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(this, TodoActivity.class), 101);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra("todo");
            Todo todo = new Todo(result, false);
            adapter.data.add(0, todo);
            adapter.notifyItemInserted(0);
            rvTodo.scrollToPosition(0);
            Log.d("todo_recieved", result);
        }
    }
}
