package com.zepto.todo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Junaid on 30,Sep,2019
 */
@Dao
public interface TodoDAO {

    @Insert
    long insertTodo(Todo todo);


    @Query("SELECT * FROM Todo")
    List<Todo> getAllTodos();
}
