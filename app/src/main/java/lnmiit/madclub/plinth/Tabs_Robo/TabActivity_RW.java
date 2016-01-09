package lnmiit.madclub.plinth.Tabs_Robo;

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
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.Robotics.Robowar.Arena_RW;
import lnmiit.madclub.plinth.Robotics.Robowar.PS_RW;
import lnmiit.madclub.plinth.Robotics.Robowar.Register_Rw;
import lnmiit.madclub.plinth.Robotics.Robowar.Rules_RW;
import lnmiit.madclub.plinth.Robotics.Robowar.Synopsis_RW;

/**
 * Created by Ankur Shukla on 1/7/2016.
 */
public class TabActivity_RW extends AppCompatActivity {

    private TextView title;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
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
            title.setText("Robo War");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent i = new Intent(TabActivity_RW.this, ListEvents.class);
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
        adapter.addFragment(new Synopsis_RW(), "Synopsis");
        adapter.addFragment(new PS_RW(), "Problem Statement");
        adapter.addFragment(new Rules_RW(), "Rules");
        adapter.addFragment(new Arena_RW(),"Arena");
        adapter.addFragment(new Register_Rw(),"Register");
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
