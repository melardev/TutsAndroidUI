package com.melardev.tutorialstheming;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
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

import static com.melardev.tutorialstheming.ActivityCreateShortcut.ACTION_SHORTCUT_CREATE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ACTION_SHORTCUT_CREATE.equals(getIntent().getAction())) {
            Toast.makeText(this, "You came from shortcut", Toast.LENGTH_SHORT).show();
            return;
        }
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

    public void demoFAB(View view) {
        startDemo(ActivityFAB.class);
    }

    public void demoNavDrawerCustomView(View view) {
        startDemo(ActivityNavDrawerList.class);
    }

    public void demoTimePickers(View view) {
        startDemo(ActivityDialogPicker.class);
    }

    public void demoAdapterViewFlipper(View view) {
        startDemo(ActivityAdapterViewFlipper.class);
    }

    public void demoPdfRenderer(View view) {
        startDemo(ActivityBasicPdfRenderer.class);
    }

    public void demoSwipe(View view) {
        startDemo(ActivityRefreshLayout.class);
    }

    public void demoCircleImg(View view) {
        startDemo(ActivityCircleImage.class);
    }

    public void demoCropImg(View view) {
        startDemo(ActivityCropImage.class);
    }
}
