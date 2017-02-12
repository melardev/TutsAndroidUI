package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ActivityTabCustomView extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_custom_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager();

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {

        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        ImageView imgCustomTab = (ImageView) v.findViewById(R.id.img_custom_tab);
        imgCustomTab.setImageResource(R.drawable.google_maps);
        TextView txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        txtTitle.setText("Google");
        TextView txtSubtitle = (TextView) v.findViewById(R.id.txtSubtitle);
        txtSubtitle.setText("Maps");
        tabLayout.getTabAt(0).setCustomView(v);

        v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        imgCustomTab = (ImageView) v.findViewById(R.id.img_custom_tab);
        imgCustomTab.setImageResource(R.drawable.google_search);
        txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        txtTitle.setText("Google");
        txtSubtitle = (TextView) v.findViewById(R.id.txtSubtitle);
        txtSubtitle.setText("Search");
        tabLayout.getTabAt(1).setCustomView(v);

        v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        imgCustomTab = (ImageView) v.findViewById(R.id.img_custom_tab);
        imgCustomTab.setImageResource(R.drawable.gmail);
        txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        txtTitle.setText("Google");
        txtSubtitle = (TextView) v.findViewById(R.id.txtSubtitle);
        txtSubtitle.setText("Gmail");
        tabLayout.getTabAt(2).setCustomView(v);
    }


    private void setupViewPager() {
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        Fragment fragOne = new FragmentTab();
        Fragment fragTwo = new FragmentTab();
        Fragment fragThree = new FragmentTab();

        Bundle args = new Bundle();
        args.putString("text", "First Fragment");
        fragOne.setArguments(args);

        args = new Bundle();
        args.putString("text", "Second Fragment");
        fragTwo.setArguments(args);

        args = new Bundle();
        args.putString("text", "Third Fragment");
        fragThree.setArguments(args);

        adapter.addFragment(fragOne, "frag");
        adapter.addFragment(fragTwo, "frag2");
        adapter.addFragment(fragThree, "frag3");
        viewPager.setAdapter(adapter);
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> listFragment = new ArrayList<>();
        private final List<String> listFragmentTitle = new ArrayList<>();

        MyFragmentPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        void addFragment(Fragment fragment, String title) {
            listFragment.add(fragment);
            listFragmentTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listFragmentTitle.get(position);
        }
    }

}
