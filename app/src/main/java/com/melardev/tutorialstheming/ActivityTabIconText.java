package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ActivityTabIconText extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_icon_text);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager();

        tabLayout.setupWithViewPager(viewPager);
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout.getTabAt(0).setIcon(R.drawable.google_maps);
        tabLayout.getTabAt(1).setIcon(R.drawable.google_search);
        tabLayout.getTabAt(2).setIcon(R.drawable.gmail);
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

        adapter.addFragment(fragOne, "frag1");
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
