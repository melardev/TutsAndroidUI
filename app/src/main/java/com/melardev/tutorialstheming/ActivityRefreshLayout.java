package com.melardev.tutorialstheming;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ActivityRefreshLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_layout);

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);

        final RecyclerView recSwipe = (RecyclerView) findViewById(R.id.recSwipe);
        recSwipe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recSwipe.setAdapter(new RecSwipeAdapter());

        swipeRefreshLayout.setColorSchemeResources(R.color.refresh, R.color.refresh1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((RecSwipeAdapter) recSwipe.getAdapter()).onRefresh();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    private class RecSwipeAdapter extends RecyclerView.Adapter<RecViewHolder> {
        int count;

        public RecSwipeAdapter() {
            count = 2;
        }

        @Override
        public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecViewHolder(LayoutInflater.from(ActivityRefreshLayout.this).inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(RecViewHolder holder, int position) {
            holder.txt1.setText("item " + position);
        }

        public void onRefresh() {
            count += 2;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return count;
        }
    }

    private class RecViewHolder extends RecyclerView.ViewHolder {
        private final TextView txt1;

        public RecViewHolder(View itemView) {
            super(itemView);
            txt1 = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
