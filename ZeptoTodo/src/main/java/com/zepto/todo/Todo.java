package com.zepto.todo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Junaid on 11,Sep,2019
 */
@Entity
public class Todo implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
    String desc = "";
    boolean isSelected = false;

    Todo(String desc, boolean isSelected) {
        this.desc = desc;
        this.isSelected = isSelected;
    }
}
