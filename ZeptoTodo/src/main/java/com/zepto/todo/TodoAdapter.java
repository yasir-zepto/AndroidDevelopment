package com.zepto.todo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junaid on 11,Sep,2019
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoVH> {

    public List<Todo> data = new ArrayList<>();

    boolean shouldSelect = false;
    private OnItemClickListener onItemClickListener = null;

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


    void enableSelection() {
        if (shouldSelect) {
            shouldSelect = false;
            for(int i =0; i < data.size(); ++i) {
                if (data.get(i).isSelected) {
                    data.get(i).isSelected = false;
                }
            }
            notifyDataSetChanged();
        } else {
            shouldSelect = true;
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class TodoVH extends RecyclerView.ViewHolder {

        private TextView txtDesc;
        private CheckBox cbSelect;

        public TodoVH(@NonNull View itemView) {
            super(itemView);
            txtDesc = itemView.findViewById(R.id.txt_desc);
            cbSelect = itemView.findViewById(R.id.checkBox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (shouldSelect) {

                        int position = getAdapterPosition();
                        boolean state = data.get(position).isSelected;
                        data.get(position).isSelected = !state;
                        notifyItemChanged(position);
                    } else if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(data.get(getAdapterPosition()), getAdapterPosition());
                    }
                }
            });
        }


        public void setData(Todo todo) {
            txtDesc.setText(todo.desc);
            cbSelect.setTag(getAdapterPosition());
            if (shouldSelect) {
                cbSelect.setVisibility(View.VISIBLE);
            } else {
                cbSelect.setVisibility(View.GONE);
            }
            if (todo.isSelected) {
                cbSelect.setChecked(true);
            } else {
                cbSelect.setChecked(false);
            }

        }
    }
}
