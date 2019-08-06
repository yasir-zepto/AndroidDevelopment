package com.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity implements TextWatcher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        EditText etName = findViewById(R.id.et_name);
        etName.addTextChangedListener(this);
    }

    /*
    * this will be called before a character is drawn when user taps a key
    *
    * */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("text_watcher", "beforeTextChanged");
    }

    /*
     * this will be called when a character is drawn on screen
     * */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("text_watcher", "onTextChanged");
        Log.d("typed_alphabet", s.toString());
    }

    /*
     * this will be called after a character is drawn on screen
     * */
    @Override
    public void afterTextChanged(Editable s) {
        Log.d("text_watcher", "afterTextChanged");

    }
}
