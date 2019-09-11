package com.zepto.todo;

/**
 * Created by Junaid on 11,Sep,2019
 */
public class Todo {

    String desc = "";
    boolean isSelected = false;

    Todo(String desc, boolean isSelected) {
        this.desc = desc;
        this.isSelected = isSelected;
    }
}
