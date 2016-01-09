package lnmiit.madclub.plinth.Tabs_Quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lnmiit.madclub.plinth.Activity.ListEvents;
import lnmiit.madclub.plinth.Model.ModelEvents;
import lnmiit.madclub.plinth.Quizzing.Tech.PS_tech;
import lnmiit.madclub.plinth.Quizzing.Tech.Register_tech;
import lnmiit.madclub.plinth.Quizzing.Tech.Rules_tech;
import lnmiit.madclub.plinth.Quizzing.Tech.Synopsis_tech;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.Robotics.LF.Arena_lf;
import lnmiit.madclub.plinth.Robotics.LF.PS_lf;
import lnmiit.madclub.plinth.Robotics.LF.Register_lf;
import lnmiit.madclub.plinth.Robotics.LF.Rules_lf;
import lnmiit.madclub.plinth.Robotics.LF.Synopsis_lf;

/**
 * Created by Ankur Shukla on 1/8/2016.
 */
public class TabActivity_TechQ extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView title;
    ArrayList<ModelEvents> modelEventsArrayList;
    String primaryColor,secondaryColor,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        modelEventsArrayList = (ArrayList<ModelEvents>) intent.getSerializableExtra("model");
        primaryColor = intent.getStringExtra("colorprimary");
        secondaryColor = intent.getStringExtra("secondarycolor");
        status = intent.getStringExtra("status");
        setContentView(R.layout.activity_tab);

        setUpToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor(primaryColor));
        tabLayout.setTabTextColors(Color.parseColor(secondaryColor), R.color.white);
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView)findViewById(R.id.title);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.parseColor(status));
            }
            toolbar.setBackgroundColor(Color.parseColor(primaryColor));
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            title.setText("Tech Quiz");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent i = new Intent(TabActivity_TechQ.this, ListEvents.class);
            i.putExtra("model", modelEventsArrayList);
            i.putExtra("colorprimary",primaryColor);
            i.putExtra("secondarycolor",secondaryColor);
            i.putExtra("status",status);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Synopsis_tech(), "Synopsis");
        adapter.addFragment(new PS_tech(), "Problem Statement");
        adapter.addFragment(new Rules_tech(), "Rules");
        adapter.addFragment(new Register_tech(),"Register");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

