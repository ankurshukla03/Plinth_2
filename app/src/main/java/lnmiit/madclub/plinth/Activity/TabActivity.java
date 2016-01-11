package lnmiit.madclub.plinth.Activity;

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

import lnmiit.madclub.plinth.Fragment.Arena;
import lnmiit.madclub.plinth.Fragment.ProblemStatement;
import lnmiit.madclub.plinth.Fragment.Register;
import lnmiit.madclub.plinth.Fragment.Rules;
import lnmiit.madclub.plinth.Fragment.Synopsis;
import lnmiit.madclub.plinth.Fragment.Synopsis_Robotics;
import lnmiit.madclub.plinth.Management.Register_nego;
import lnmiit.madclub.plinth.Management.Register_sif;
import lnmiit.madclub.plinth.Model.ModelEvents;
import lnmiit.madclub.plinth.R;

/**
 * Created by Infinia on 10-01-2016.
 */
public class TabActivity extends AppCompatActivity {

    ArrayList<ModelEvents> modelEventsArrayList;
    String primaryColor, secondaryColor, status;
    String type;
    private Toolbar mToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        type = getIntent().getExtras().getString("type");
        modelEventsArrayList = (ArrayList<ModelEvents>) intent.getSerializableExtra("model");
        primaryColor = intent.getStringExtra("colorprimary");
        secondaryColor = intent.getStringExtra("secondarycolor");
        status = intent.getStringExtra("status");
        setContentView(R.layout.activity_tabview);

        setUpToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor(primaryColor));
        //tabLayout.setTabTextColors(Color.parseColor(secondaryColor),R.color.w);
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.title);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.parseColor(status));
            }
            mToolbar.setBackgroundColor(Color.parseColor(primaryColor));
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            title.setText(type);
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent i = new Intent(TabActivity.this, ListEvents.class);
            i.putExtra("model", modelEventsArrayList);
            i.putExtra("colorprimary", primaryColor);
            i.putExtra("secondarycolor", secondaryColor);
            i.putExtra("status", status);
            startActivity(i);
           /* overridePendingTransition(R.anim.slide_out_left,
                    R.anim.slide_in_right);*/
            finish();
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(TabActivity.this, ListEvents.class);
        i.putExtra("model", modelEventsArrayList);
        i.putExtra("colorprimary", primaryColor);
        i.putExtra("secondarycolor", secondaryColor);
        i.putExtra("status", status);
        startActivity(i);
           /* overridePendingTransition(R.anim.slide_out_left,
                    R.anim.slide_in_right);*/
        finish();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        switch (type) {
            case "Transporter":
                adapter.addFragment(new Synopsis_Robotics(-6,TabActivity.this), "Synopsis");
                adapter.addFragment(new ProblemStatement(-6), "Problem Statement");
                adapter.addFragment(new Rules(-6), "Rules");
                adapter.addFragment(new Arena(-6), "Arena");
                adapter.addFragment(new Register("Priyansh Mangal","09529666908","priyanshmangal@gmail.com","Kritika Karwasra","08503926151","mekritika28@gmail.com",
                        "https://docs.google.com/forms/d/19OJ19k7xw64Vq5iZ5ee2lxLfKPRzNhtAq_VEF6K5U5M/viewform?embedded=true","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Robowar":
                adapter.addFragment(new Synopsis_Robotics(-5,TabActivity.this), "Synopsis");
                adapter.addFragment(new ProblemStatement(-5), "Problem Statement");
                adapter.addFragment(new Rules(-5), "Rules");
                adapter.addFragment(new Arena(-5), "Arena");
                adapter.addFragment(new Register("Samyak Dutt Gupta","09462066697","sdgupta.gupta9@gmail.com","Abhishek Sukhwal","07597722415","abhisheksukhwal9@gmail.com",
                        "https://docs.google.com/forms/d/1C7E-RXx8ck_U7bg8wno6MyM158zK2K8NyOP6Fw6vZ8U/viewform?embedded=true","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Line Follower":
                adapter.addFragment(new Synopsis_Robotics(-4,TabActivity.this), "Synopsis");
                adapter.addFragment(new ProblemStatement(-4), "Problem Statement");
                adapter.addFragment(new Rules(-4), "Rules");
                adapter.addFragment(new Arena(-4), "Arena");
                adapter.addFragment(new Register("Ankit Puri","08003194158","ankitpuri1995@gmail.com","Aayush Agarwal","09462035225","aayushag007@gmail.com",
                        "https://docs.google.com/forms/d/1ibO17nEovdrhhxM7HzQjCcivrsWtUtZ9kzb8t699u2I/viewform?embedded=true","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Lumos":
                adapter.addFragment(new Synopsis_Robotics(-3,TabActivity.this), "Synopsis");
                adapter.addFragment(new ProblemStatement(-3), "Problem Statement");
                adapter.addFragment(new Rules(-3), "Rules");
                adapter.addFragment(new Arena(-3), "Arena");
                adapter.addFragment(new Register("Vipul Behl","09468590302","vipul.viki@gmail.com","Sumit Sapra","09782799066","sumitsapra008@gmail.com",
                        "https://docs.google.com/forms/d/1d9TdRc0afutOn1_Ie_5D_h-0KGdL0L6WwAF7sPGT7C8/viewform?embedded=true","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Robo Race":
                adapter.addFragment(new Synopsis_Robotics(-2,TabActivity.this), "Synopsis");
                adapter.addFragment(new ProblemStatement(-2), "Problem Statement");
                adapter.addFragment(new Rules(-2), "Rules");
                adapter.addFragment(new Arena(-2), "Arena");
                adapter.addFragment(new Register("Harshit Somani","08003244787","harshitsom@gmail.com","Mithin Nair","07073837006","nairmithin2@gmail.com",
                        "https://docs.google.com/forms/d/1d0-kYWS42pSIkFl0U-Xi0lf-PCURFeWr6zDKUe7KV5o/viewform?embedded=true","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Robo Soccer":
                adapter.addFragment(new Synopsis_Robotics(-1,TabActivity.this), "Synopsis");
                adapter.addFragment(new ProblemStatement(-1), "Problem Statement");
                adapter.addFragment(new Rules(-1), "Rules");
                adapter.addFragment(new Arena(-1), "Arena");
                adapter.addFragment(new Register("Bharti Sharma","09462733116","itsbhartitime1@gmail.com","Lokesh Todwal","09462999051","lokeshtodwal005@gmail.com",
                        "https://docs.google.com/forms/d/1jn3P8F9rOYOr1ccqZIsfLgqjKCF857UgSPlLeoP1yqY/viewform?embedded=true","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Biz Quiz":
                adapter.addFragment(new Synopsis(0), "Synopsis");
                adapter.addFragment(new ProblemStatement(0), "Problem Statement");
                adapter.addFragment(new Rules(0), "Rules");
                adapter.addFragment(new Register("Shubham Pandey","07597022620","y13uc283@lnmiit.ac.in","Navneet Kumar","08003252847","y13uc173@lnmiit.ac.in","","","",status), "Register");
                break;
            case "Tech Quiz":
                adapter.addFragment(new Synopsis(1), "Synopsis");
                adapter.addFragment(new ProblemStatement(1), "Problem Statement");
                adapter.addFragment(new Rules(1), "Rules");
                adapter.addFragment(new Register("Shubham Pandey","07597022620","y13uc283@lnmiit.ac.in","Sidharth Sethia","07023479993","y13uc290@lnmiit.ac.in","","","",status), "Register");
                break;
            case "Negotio":
                adapter.addFragment(new Synopsis(2), "Synopsis");
                adapter.addFragment(new ProblemStatement(2), "Event Description");
                adapter.addFragment(new Rules(2), "Rules");
                adapter.addFragment(new Register_nego(), "Register");
                break;
            case "Startup Intern Fair":
                adapter.addFragment(new Synopsis(3), "Synopsis");
                adapter.addFragment(new ProblemStatement(3), "Event Description");
                adapter.addFragment(new Rules(3), "Rules");
                adapter.addFragment(new Register_sif(),"Register");
                break;
            case "Finders Keeper":
                adapter.addFragment(new Synopsis(4), "Synopsis");
                adapter.addFragment(new ProblemStatement(4), "Problem Statement");
                adapter.addFragment(new Rules(4), "Rules");
                adapter.addFragment(new Register("Ishant Rajpurohit","0887533243","y13uc283@lnmiit.ac.in","","","","","","",status),"Register");
                break;
            case "Lyrewrite":
                adapter.addFragment(new Synopsis(5), "Synopsis");
                adapter.addFragment(new ProblemStatement(5), "Problem Statement");
                adapter.addFragment(new Rules(5), "Rules");
                adapter.addFragment(new Register("Avina Jain","09530457925","","Ritwik Bang","08003585305","","","","",status),"Register");
                break;
            case "Floor Crossing":
                adapter.addFragment(new Synopsis(6), "Synopsis");
                adapter.addFragment(new ProblemStatement(6), "Problem Statement");
                adapter.addFragment(new Rules(6), "Rules");
                adapter.addFragment(new Register("Bhavik Thakkar","08003253190","","Mihika Naik","09602974538","","","","",status), "Register");
                break;
            case "TurnCoat":
                adapter.addFragment(new Synopsis(7), "Synopsis");
                adapter.addFragment(new ProblemStatement(7), "Problem Statement");
                adapter.addFragment(new Rules(7), "Rules");
                adapter.addFragment(new Register("Sonali Gupta","09462900363","","Sobhit Asai","09479361848","","","","",status),"Register");
                break;
            case "Astro Hunt":
                adapter.addFragment(new Synopsis(8), "Synopsis");
                adapter.addFragment(new ProblemStatement(8), "Problem Statement");
                adapter.addFragment(new Rules(8), "Rules");
                adapter.addFragment(new Register("Chitresh Sharma","08764338048","chitreshcms@gmail.com","Samyak Gupta","09462066697","sdgupta.gupta9@gmail.com",
                        "https://docs.google.com/forms/d/1zkygUeLgbcMcQpRZ44nzY7iXq8fqF-DlSLnqt_5FB-U/viewform?embedded=true","","",status), "Register");
                break;
            case "Asgard":
                adapter.addFragment(new Synopsis(9), "Synopsis");
                adapter.addFragment(new ProblemStatement(9), "Problem Statement");
                adapter.addFragment(new Rules(9), "Rules");
                adapter.addFragment(new Register("Mihika Naik","09602974538","p.mihika@gmail.com","Shubham Gupta","07725924217","samigupta248@gmail.com",
                        "https://docs.google.com/forms/d/1zkygUeLgbcMcQpRZ44nzY7iXq8fqF-DlSLnqt_5FB-U/viewform?embedded=true","","",status), "Register");
                break;
            case "Into the Universe":
                adapter.addFragment(new Synopsis(10), "Synopsis");
                adapter.addFragment(new ProblemStatement(10), "Problem Statement");
                adapter.addFragment(new Rules(10), "Rules");
                adapter.addFragment(new Register("Kushagra Sharma","07597603418","ramkrishn12345@gmail.com","Srishti Bhardwaj","09461631493","bsrishtib@gmail.com",
                        "https://docs.google.com/forms/d/1zkygUeLgbcMcQpRZ44nzY7iXq8fqF-DlSLnqt_5FB-U/viewform?embedded=true","","",status), "Register");
                break;
            case "IUPC":
                adapter.addFragment(new Synopsis(11), "Synopsis");
                adapter.addFragment(new ProblemStatement(11), "Problem Statement");
                adapter.addFragment(new Rules(11), "Rules");
                adapter.addFragment(new Register("Yash Varyani","07728990660","veyron1306@gmail.com","Vaibhav Shrotriya","07793075905","vaibhavshrotriya4@gmail.com",
                        "https://docs.google.com/forms/d/1BW3mPPDbm1eIkZTt1TyRjwuC16e2uYEDpw-VtLY4Z4s/viewform?c=0&w=1","","",status), "Register");
                break;
            case "Distraction IUPC":
                adapter.addFragment(new Synopsis(12), "Synopsis");
                adapter.addFragment(new ProblemStatement(12), "Problem Statement");
                adapter.addFragment(new Rules(12), "Rules");
                adapter.addFragment(new Register("Yash Varyani","07728990660","veyron1306@gmail.com","Vaibhav Shrotriya","07793075905","vaibhavshrotriya4@gmail.com","","","",status), "Register");
                break;
            case "Fix the Bug":
                adapter.addFragment(new Synopsis(13), "Synopsis");
                adapter.addFragment(new ProblemStatement(13), "Problem Statement");
                adapter.addFragment(new Rules(13), "Rules");
                adapter.addFragment(new Register("Yash Varyani","07728990660","veyron1306@gmail.com","Vaibhav Shrotriya","07793075905","vaibhavshrotriya4@gmail.com","","","",status), "Register");
                break;
            case "Data Science":
                adapter.addFragment(new Synopsis(14), "Home");
                adapter.addFragment(new ProblemStatement(14), "Workshop Content");
                adapter.addFragment(new Rules(14), "Benefits");
                adapter.addFragment(new Register("Rohit Hinduja","08989171066","rohithinduja2013@gmail.com","Shubham Dangi","09828853059","theshubham.dangi@gmail.com","https://docs.google.com/forms/d/1jch2Z3_8k4o1MCUr-Ns5uAVhhYHdJmd_j32oo3S1tpk/viewform?c=0&w=1&usp=send_form",
                        "","http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Internet of Things":
                adapter.addFragment(new Synopsis(15), "Home");
                adapter.addFragment(new ProblemStatement(15), "Workshop Content");
                adapter.addFragment(new Rules(15), "Benefits");
                adapter.addFragment(new Register("Kapil Matani","09462317503","kapilmatani03@gmail.com",
                        "Deepika Singhal","09461481539","deepikasinghal.07@gmail.com","https://docs.google.com/forms/d/1jch2Z3_8k4o1MCUr-Ns5uAVhhYHdJmd_j32oo3S1tpk/viewform?c=0&w=1","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Vision Botics":
                adapter.addFragment(new Synopsis(16), "Home");
                adapter.addFragment(new ProblemStatement(16), "Workshop Content");
                adapter.addFragment(new Rules(16), "Benefits");
                adapter.addFragment(new Register("Kapil Matani","09462317503","kapilmatani03@gmail.com",
                        "Deepika Singhal","09461481539","deepikasinghal.07@gmail.com","https://docs.google.com/forms/d/1jch2Z3_8k4o1MCUr-Ns5uAVhhYHdJmd_j32oo3S1tpk/viewform?c=0&w=1","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;
            case "Networking and Cyber Security":
                adapter.addFragment(new Synopsis(17), "Home");
                adapter.addFragment(new ProblemStatement(17), "Workshop Content");
                adapter.addFragment(new Rules(17), "Benefits");
                adapter.addFragment(new Register("Kapil Matani","09462317503","kapilmatani03@gmail.com",
                        "Deepika Singhal","09461481539","deepikasinghal.07@gmail.com","https://docs.google.com/forms/d/1jch2Z3_8k4o1MCUr-Ns5uAVhhYHdJmd_j32oo3S1tpk/viewform?c=0&w=1","",
                        "http://thecollegefever.com/plinth",status), "Register");
                break;

        }
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


