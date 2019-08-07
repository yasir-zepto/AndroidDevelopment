package com.helloworld;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Junaid on 07,Aug,2019
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactVH> {

    //data that would be populated in the view

    private String[] contacts = {"Junaid", "Umar", "Usama","Junaid", "Umar", "Usama","Junaid", "Umar", "Usama"};


    /*
    *
    * this method is called to create the view that would be displayed in the list
    *
    * We inflate our item layout in this method.. so that Recycler View can draw this item on screen
    *
    * */

    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        //this object will help to inflate layout file
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View contactView = layoutInflater.inflate(R.layout.item_contact, viewGroup, false);
        return new ContactVH(contactView);
    }

    /*
    * We bind data (stitched/populated) to view here
    * */

    @Override
    public void onBindViewHolder(@NonNull ContactVH contactVH, int pos) {
        contactVH.txtName.setText(contacts[pos]);
    }

    /*
    *
    * Number of views that will be populated
    *
    * */


    @Override
    public int getItemCount() {
        return contacts.length;
    }

    class ContactVH extends RecyclerView.ViewHolder {
        TextView txtName;

        public ContactVH(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
        }


    }
}
