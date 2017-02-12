package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

import java.util.ArrayList;

public class ActivityStackView extends AppCompatActivity {

    private StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        stackView = (StackView) findViewById(R.id.stackView);
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.chrome);
        images.add(R.drawable.gmail);
        images.add(R.drawable.google_maps);
        images.add(R.drawable.google_search);

        stackView.setAdapter(new StackAdapter(images));
    }

    private class StackAdapter extends BaseAdapter {
        ArrayList<Integer> images;

        public StackAdapter(ArrayList<Integer> images) {
            this.images = images;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View v = getLayoutInflater().inflate(R.layout.img_stack, viewGroup, false);
            ImageView img = (ImageView) v.findViewById(R.id.imgStack);
           // img.setBackgroundColor(images.get(position));
            img.setImageResource(images.get(position));
            return v;
        }
    }
}
