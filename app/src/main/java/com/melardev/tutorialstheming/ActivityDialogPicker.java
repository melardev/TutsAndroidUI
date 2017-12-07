package com.melardev.tutorialstheming;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import be.billington.calendar.recurrencepicker.RecurrencePickerDialog;

public class ActivityDialogPicker extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
        , TimePickerDialog.OnTimeSetListener, RecurrencePickerDialog.OnRecurrenceSetListener {

    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_picker);

        txtInfo = (TextView) findViewById(R.id.txtDateInfo);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        txtInfo.setText("Date -> " + year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
    }

    public void pickDate(View view) {
        final Calendar now = Calendar.getInstance();
        final DatePickerDialog datedialog = new DatePickerDialog(this, this, now.get(Calendar.YEAR)
                , now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        datedialog.show();
    }

    public void pickTime(View view) {
        Calendar cal = Calendar.getInstance();
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(this, this, hourOfDay, minute, false);
        dialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        txtInfo.setText("Time -> " + hourOfDay + ":" + minute);
    }

    public void pickDays(View view) {
        RecurrencePickerDialog recurrencePickerDialog = new RecurrencePickerDialog();
        recurrencePickerDialog.setOnRecurrenceSetListener(this);
        recurrencePickerDialog.show(getSupportFragmentManager(), "recurrencePicker");
    }

    @Override
    public void onRecurrenceSet(String rrule) {
        txtInfo.setText(rrule);
    }
}
