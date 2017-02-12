package com.melardev.tutorialstheming;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ActivitySnackBar extends AppCompatActivity {

    private RelativeLayout relLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        relLayout = (RelativeLayout) findViewById(R.id.activity_snack_bar);
        final Snackbar snackbar = Snackbar.make(relLayout, "Snackbar Example", Snackbar.LENGTH_LONG)
                .setAction("ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ActivitySnackBar.this, "Snack Action clicked", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.GREEN);

        ((TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text)).setTextColor(Color.MAGENTA);
        relLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.show();
            }
        });

    }
}
