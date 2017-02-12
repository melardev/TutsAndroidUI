package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ActivityImmersive extends AppCompatActivity {

    private GestureDetectorCompat mGestureDetector;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (getSupportActionBar() != null && getSupportActionBar().isShowing()) {
                hideUI();
            } else {
                showSystemUI();
            }
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
        // hideUI();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void hideUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                        View.SYSTEM_UI_FLAG_FULLSCREEN | //Full screen mode
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |     //Stable when using multiple flags
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | //avoid artifacts when FLAG_FULLSCREEN
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }
}
