package lnmiit.madclub.plinth.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import lnmiit.madclub.plinth.Fragment.Home;
import lnmiit.madclub.plinth.NavigationDrawerFragment.ContactUs;
import lnmiit.madclub.plinth.NavigationDrawerFragment.Developer;
import lnmiit.madclub.plinth.NavigationDrawerFragment.Map;
import lnmiit.madclub.plinth.NavigationDrawerFragment.Talks;
import lnmiit.madclub.plinth.NavigationDrawerFragment.Workshops;
import lnmiit.madclub.plinth.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        initView();
        initializeNavigationDrawer();

        setFragment(0);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case  R.id.nav_events:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_map:
                                menuItem.setChecked(true);
                                setFragment(3);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_sponsor:
                                menuItem.setChecked(true);
                                setFragment(4);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_social:
                                drawerLayout.closeDrawer(GravityCompat.START);
                                final ImageView fb, twitter, linkedin;
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
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
                                return true;
                            case R.id.nav_contact_us:
                                menuItem.setChecked(true);
                                setFragment(5);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_share:

                                /*setFragment(4);*/
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
                                return true;
                            case R.id.nav_developer:
                                menuItem.setChecked(true);
                                setFragment(6);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            default:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                    }
                });
    }

    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new Home();
                break;
            case 3:
                fragment = new Map();
                break;
            case 4:
                fragment = new ContactUs();
                break;
            case 5:
                fragment = new ContactUs();
                break;
            case 6:
                fragment = new Developer();
                break;
            default:
                fragment = new Home();
                break;

        }
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
