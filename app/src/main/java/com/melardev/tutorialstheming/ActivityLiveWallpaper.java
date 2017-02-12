package com.melardev.tutorialstheming;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class ActivityLiveWallpaper extends AppCompatActivity {

    private TextView txtColorChooser;
    Button btnScreenLight;
    public static int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_wallpaper);
        txtColorChooser = (TextView) findViewById(R.id.txtColorChooser);
        btnScreenLight = (Button) findViewById(R.id.btnScreenLight);

        btnScreenLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPreferences(MODE_PRIVATE).edit().putInt("color", color).apply();
                changeWallpaper();
            }
        });

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        color = prefs.getInt("color", 0x000);
        onColorChoosed(color);
    }

    private void onColorChoosed(int c) {
        color = c;
        txtColorChooser.setBackgroundColor(color);
    }

    public void pickColor(View view) {
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(color)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        Log.d("DEBUG", String.valueOf(selectedColor));
                        Toast.makeText(ActivityLiveWallpaper.this, "onColorSelected: 0x" + Integer.toHexString(selectedColor), Toast.LENGTH_SHORT).show();
                        //txtColorChooser.setBackgroundColor(selectedColor);
                        onColorChoosed(selectedColor);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();

    }

    public void changeWallpaper() {
        Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(this, ServiceWallpaper.class));
        startActivity(intent);
    }
}
