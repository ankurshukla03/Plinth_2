package lnmiit.madclub.plinth.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import lnmiit.madclub.plinth.NavigationDrawerFragment.Home;
import lnmiit.madclub.plinth.NavigationDrawerFragment.ContactUs;
import lnmiit.madclub.plinth.NavigationDrawerFragment.Developer;
import lnmiit.madclub.plinth.NavigationDrawerFragment.Map;
import lnmiit.madclub.plinth.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private TextView title;
    private boolean viewIsAtHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        initView();
        initializeNavigationDrawer();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame, new Home()).commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (!viewIsAtHome) { //if the current view is not the News fragment
                setFragment(R.id.nav_events);
            } else {
                moveTaskToBack(true);  //If view is in News fragment, exit application
            }
        }
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView)findViewById(R.id.title);
        title.setText("Plinth");
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }



    private void initView()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void initializeNavigationDrawer()
    {
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(final MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    private void setFragment(int id) {
        Fragment fragment = null;

        Class fragmentClass = null;
        switch (id) {
            case R.id.nav_events:
                final Menu navMenu = navigationView.getMenu();
                final MenuItem item = navMenu.findItem(R.id.nav_events);
                item.setChecked(true);
                viewIsAtHome = true;
                switchFragment(Home.class);
                title.setText("Events");
                break;
            case R.id.nav_map:
                viewIsAtHome = false;
                switchFragment(Map.class);
                title.setText("Map");
                break;
            case R.id.nav_social:
                drawerLayout.closeDrawer(GravityCompat.START);
                final ImageView fb, twitter, linkedin;
                MaterialDialog materialDialog = new MaterialDialog.Builder(MainActivity.this)
                        .title("Spread Love")
                        .customView(R.layout.dialog_share, true)
                        .cancelable(true)
                        .positiveText("Done")
                        .build();
                fb = (ImageView) materialDialog.getCustomView().findViewById(R.id.fb);
                twitter = (ImageView) materialDialog.getCustomView().findViewById(R.id.yt);
                linkedin = (ImageView) materialDialog.getCustomView().findViewById(R.id.gp);
                fb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "https://www.facebook.com/Plinth.LNMIIT/?fref=ts";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });
                twitter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "https://youtu.be/Sl01sf3RP9I";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });
                linkedin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "https://plus.google.com/+PLINTHLNMIIT/posts";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });
                materialDialog.show();
                break;
            case R.id.nav_contact_us:
                viewIsAtHome = false;
                switchFragment(ContactUs.class);
                title.setText("Contact Us");
                break;
            case R.id.nav_share:
                drawerLayout.closeDrawer(GravityCompat.START);
                String share = "Hey! I am enjoying using the official Plinth app!" +
                        " It's time you have it too! To get " +
                        " the entire Plinth schedule and a lot more interactive activities " +
                        "download the app from the play store";
                String shareBody = share + "\nhttps://play.google.com/store/apps/details?id=lnmiit.madclub.plinth";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Official Plinth 2016 app");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.nav_developer:
                viewIsAtHome = false;
                switchFragment(Developer.class);
                title.setText("Developers");
                break;
            default:
                switchFragment(Home.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        drawer.closeDrawers();
    }




    private void switchFragment(Class fragmentClass)
    {
        Fragment fragment=null;
        try {
            fragment  = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
    }




    public void selectDrawerItem(MenuItem menuItem) {
        if(!(menuItem.getItemId()==R.id.nav_share || menuItem.getItemId()==R.id.nav_social)) {
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());

        }
        setFragment(menuItem.getItemId());
    }

}
