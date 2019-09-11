package com.zepto.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView todoList = findViewById(R.id.rv_todo);
        TodoAdapter adapter = new TodoAdapter();
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
        todoList.setAdapter(adapter);
        todoList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}
