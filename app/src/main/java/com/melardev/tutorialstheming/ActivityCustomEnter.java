package com.melardev.tutorialstheming;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCustomEnter extends AppCompatActivity {

    private EditText etxtName;

    EditText.OnEditorActionListener exampleListener = new EditText.OnEditorActionListener() {

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                Toast.makeText(ActivityCustomEnter.this, "Done", Toast.LENGTH_SHORT).show();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_enter);

        etxtName = (EditText) findViewById(R.id.etxtName);
        etxtName.setOnEditorActionListener(exampleListener);


    }
}
