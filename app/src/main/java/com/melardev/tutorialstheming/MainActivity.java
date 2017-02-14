package com.melardev.tutorialstheming;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void startDemo(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    public void demoWallpaper(View view) {
        startDemo(ActivityLiveWallpaper.class);
    }

    public void demoColorPicker(View view) {
        startDemo(ActivityColorPicker.class);
    }

    public void demoColorPickerAdv(View view) {
        startDemo(ActivityColorPickerAdv.class);
    }

    public void demoTabViewPager(View view) {
        startDemo(ActivityTabIconText.class);
    }

    public void demoTabPagerCustom(View view) {
        startDemo(ActivityTabCustomView.class);
    }

    public void demoImgSwitcher(View view) {
        startDemo(ActivityImageSwitcher.class);
    }

    public void demoExpandableList(View view) {
        startDemo(ActivityExpandableListView.class);
    }

    public void demoRecycler(View view) {
        startDemo(ActivityRecycler.class);
    }

    public void demoListV(View view) {
        startDemo(ActivityListView.class);
    }

    public void demoDlgFragment(View view) {
        startDemo(ActivityDialogFragment.class);
    }

    public void demoCustomEnter(View view) {
        startDemo(ActivityCustomEnter.class);
    }

    public void demoActivityDialog(View view) {
        startDemo(ActivityDialog.class);
    }
}
