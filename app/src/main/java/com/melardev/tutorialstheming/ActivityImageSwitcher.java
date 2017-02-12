package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ActivityImageSwitcher extends AppCompatActivity {

    private ImageSwitcher imgSwitcher;
    private Button btnPrev;
    private Button btnNext;
    private int[] images;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        imgSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrev = (Button) findViewById(R.id.btnPrev);

        final Animation inRightToCenter = AnimationUtils.loadAnimation(this, R.anim.img_switch_in_rc);
        final Animation outCenterToLeft = AnimationUtils.loadAnimation(this, R.anim.img_switch_out_cl);

        final Animation inLeftToCenter = AnimationUtils.loadAnimation(this, R.anim.img_switch_in_lc);
        final Animation outCenterToRight = AnimationUtils.loadAnimation(this, R.anim.img_switch_out_cr);


        imgSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView img = new ImageView(ActivityImageSwitcher.this);
                img.setScaleType(ImageView.ScaleType.FIT_CENTER); //FIT_CENTER
                return img;
            }
        });

        images = new int[]{R.drawable.chrome, R.drawable.gmail, R.drawable.google_maps, R.drawable.google_search};
        count = 0;
        imgSwitcher.setImageResource(images[0]);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    imgSwitcher.setInAnimation(inLeftToCenter);
                    imgSwitcher.setOutAnimation(outCenterToRight);
                    count--;
                    imgSwitcher.setImageResource(images[count]);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count < images.length - 1) {
                    imgSwitcher.setInAnimation(inRightToCenter);
                    imgSwitcher.setOutAnimation(outCenterToLeft);
                    count++;
                    imgSwitcher.setImageResource(images[count]);
                }
            }
        });
    }
}
