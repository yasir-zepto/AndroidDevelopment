package com.zepto.todo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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

    @Update
    int updateTodo(Todo todo);

    @Delete
    int delete(Todo todo);
}
