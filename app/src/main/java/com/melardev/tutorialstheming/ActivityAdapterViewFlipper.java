package com.melardev.tutorialstheming;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAdapterViewFlipper extends AppCompatActivity {

    private AdapterViewFlipper adapterViewFlipper;

    static String[] labels = {"chrome", "maps", "search"};
    static int[] images = {R.drawable.chrome, R.drawable.google_maps, R.drawable.google_search};
    private Button btnStartStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        btnStartStop = (Button) findViewById(R.id.btnStartStop);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        adapterViewFlipper.setAdapter(new MyAdapter(labels, images));
        adapterViewFlipper.setFlipInterval(2 * 1000);
        adapterViewFlipper.setAutoStart(true);
    }

    public void startStop(View view) {
        if (adapterViewFlipper.isFlipping()) {
            adapterViewFlipper.stopFlipping();
            btnStartStop.setText("Start");

        } else {
            adapterViewFlipper.startFlipping();
            btnStartStop.setText("Stop");
        }
    }

    public void onPrevClicked(View view) {
        adapterViewFlipper.showPrevious();
    }

    public void onNextClicked(View view) {
        adapterViewFlipper.showNext();
    }

    class MyAdapter extends BaseAdapter {

        int[] images;
        String[] names;

        public MyAdapter(String[] names, int[] images) {
            this.images = images;
            this.names = names;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.view_flipper_item, null);
            TextView label = (TextView) view.findViewById(R.id.label);
            ImageView image = (ImageView) view.findViewById(R.id.image);
            label.setText(labels[position]);
            image.setImageResource(images[position]);
            return view;
        }
    }
}
