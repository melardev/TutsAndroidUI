package com.melardev.tutorialstheming;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class ActivityExpandableListView extends AppCompatActivity {

    private ExpandableListView exlv;
    String[] headers = {"C++", "Java", "Python", "PHP"};
    String[][] topics = {
            {"OOP", "Networking", "Data structures"},
            {"OOP", "Networking", "Data structures"},
            {"OOP", "Networking", "Data structures"},
            {"OOP", "Networking", "Data structures"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        exlv = (ExpandableListView) findViewById(R.id.expandableListView);
        exlv.setAdapter(new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return headers.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return topics[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return groupPosition;
            }

            @Override
            public Object getChild(int i, int i1) {
                return null;
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                TextView txtView = new TextView(getApplicationContext());
                txtView.setText(headers[groupPosition]);
                txtView.setPadding(40, 2, 2, 2);
                txtView.setTextColor(Color.BLACK);
                return txtView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
                TextView txtView = new TextView(getApplicationContext());
                txtView.setText(topics[groupPosition][childPosition]);
                txtView.setPadding(40, 2, 2, 2);
                txtView.setTextColor(Color.MAGENTA);
                return txtView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
        });

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

        // exlv.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));
    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}
