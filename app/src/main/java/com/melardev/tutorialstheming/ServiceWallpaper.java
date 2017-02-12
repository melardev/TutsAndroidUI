package com.melardev.tutorialstheming;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by melardev on 2/11/2017.
 */

public class ServiceWallpaper extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new ServiceWallpaperEngine();
    }

    //Handles the drawing of the Wallpaper and its lifecycle
    public class ServiceWallpaperEngine extends Engine {

        float x;
        float y;

        private final Handler handler = new Handler();
        private final Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                draw();
            }

        };

        public ServiceWallpaperEngine() {
            handler.post(drawRunner);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            if (visible) {
                handler.post(drawRunner);
            } else {
                handler.removeCallbacks(drawRunner);
            }
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            handler.removeCallbacks(drawRunner);
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        if (event.getX() - x > 0) //RIGHT
                            MainActivity.color += 25;
                        else if (event.getX() - x < 0) //LEFT
                            MainActivity.color -= 25;
                    }
                    Paint p = new Paint();
                    p.setColor(Color.WHITE);
                    p.setTypeface(Typeface.DEFAULT);
                    p.setAntiAlias(true);
                    //p.setElegantTextHeight(true);
                    p.setTextAlign(Paint.Align.CENTER);
                    p.setTextSize(50);

                    Rect rect = new Rect();
                    canvas.getClipBounds(rect);
                    canvas.drawColor(MainActivity.color);
                    if (event.getX() != x || event.getY() != y)
                        canvas.drawText("X : " + x + " Y: " + y, rect.centerX(), rect.centerY(), p);
                }
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }

            x = event.getX();
            y = event.getY();

            super.onTouchEvent(event);
        }

        private void draw() {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(MainActivity.color);
                }
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
            // handler.removeCallbacks(drawRunner);
            /*if (visible) {
                handler.postDelayed(drawRunner, 5000);
            }*/
        }
    }
}