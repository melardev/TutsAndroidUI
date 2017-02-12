package com.melardev.tutorialstheming;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class ActivityDialogs extends AppCompatActivity {

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            txtSelected.setText( String.format("%d:%2d", hourOfDay,minute));
        }

    };
    private TextView txtSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        txtSelected = (TextView) findViewById(R.id.txtSelectedText);
    }

    public void onTimePickerClicked(View view) {
        new TimePickerDialog(this, onTimeSetListener, 0, 0
                , false //true -> 24h; false -> AM/PM
        ).show();
    }
}
