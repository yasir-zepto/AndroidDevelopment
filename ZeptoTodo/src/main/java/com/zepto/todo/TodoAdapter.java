package com.zepto.todo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Junaid on 11,Sep,2019
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoVH> {

    public ArrayList<Todo> data = new ArrayList<>();

    @NonNull
    @Override
    public TodoVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TodoVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_todo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoVH todoVH, int position) {
        todoVH.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class TodoVH extends RecyclerView.ViewHolder {

        private TextView txtDesc;

        public TodoVH(@NonNull View itemView) {
            super(itemView);
            txtDesc = itemView.findViewById(R.id.txt_desc);
        }


        public void setData(Todo todo) {
            txtDesc.setText(todo.desc);

        }
    }
}
