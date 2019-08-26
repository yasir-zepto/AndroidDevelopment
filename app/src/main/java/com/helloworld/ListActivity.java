package com.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView rvContacts = findViewById(R.id.rv_contacts);
        ContactsAdapter adapter = new ContactsAdapter();
        rvContacts.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvContacts.setLayoutManager(layoutManager);

        //implemet item click
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position, String contact) {
        Toast.makeText(this, "Clicked Contact is: "+contact, Toast.LENGTH_SHORT).show();

    }
}
