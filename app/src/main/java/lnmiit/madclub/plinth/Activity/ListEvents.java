package lnmiit.madclub.plinth.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

import lnmiit.madclub.plinth.Adapter.EventsAdapter;
import lnmiit.madclub.plinth.Model.ModelEvents;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.TabLit.Tab_fc;
import lnmiit.madclub.plinth.TabLit.Tab_fk;
import lnmiit.madclub.plinth.TabLit.Tab_lw;
import lnmiit.madclub.plinth.TabLit.Tab_tc;
import lnmiit.madclub.plinth.Tab_Astro.Tab_Asgard;
import lnmiit.madclub.plinth.Tab_Astro.Tab_AH;
import lnmiit.madclub.plinth.Tab_Astro.Tab_itu;
import lnmiit.madclub.plinth.Tab_Mang.Tab_nego;
import lnmiit.madclub.plinth.Tab_Mang.Tab_sif;
import lnmiit.madclub.plinth.Tabs_Coding.Tab_IUPC;
import lnmiit.madclub.plinth.Tabs_Coding.Tab_diupc;
import lnmiit.madclub.plinth.Tabs_Coding.Tab_fib;
import lnmiit.madclub.plinth.Tabs_Quiz.TabActivity_BizQ;
import lnmiit.madclub.plinth.Tabs_Quiz.TabActivity_TechQ;
import lnmiit.madclub.plinth.Tabs_Robo.TabActivity_LF;
import lnmiit.madclub.plinth.Tabs_Robo.TabActivity_Lumos;
import lnmiit.madclub.plinth.Tabs_Robo.TabActivity_RR;
import lnmiit.madclub.plinth.Tabs_Robo.TabActivity_RW;
import lnmiit.madclub.plinth.Tabs_Robo.TabActivity_Rs;
import lnmiit.madclub.plinth.Tabs_Robo.TabActivity_Trans;
import lnmiit.madclub.plinth.Widget.RecyclerItemClickListener;

/**
 * Created by Ankur Shukla on 12/31/2015.
 */
public class ListEvents extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    Toolbar toolbar;
    TextView toolbar_txt;
    ImageButton back;
    String primaryColor,secondaryColor,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final ArrayList<ModelEvents> modelEventsArrayList = (ArrayList<ModelEvents>) intent.getSerializableExtra("model");
        primaryColor = intent.getStringExtra("colorprimary");
        secondaryColor = intent.getStringExtra("secondarycolor");
        status = intent.getStringExtra("status");
        setContentView(R.layout.listview);

        setUpToolbar();

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_viewlist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(ListEvents.this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EventsAdapter(modelEventsArrayList,ListEvents.this);
        mRecyclerView.setAdapter(mAdapter);
       /* listView.setAdapter(eventsAdapter);*/

        mRecyclerView.addOnItemTouchListener(new
                RecyclerItemClickListener(ListEvents.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ModelEvents modelEvents = modelEventsArrayList.get(position);

                if (modelEvents.name.equals("Transporter")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_Trans.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Robowar")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_RW.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Line Follower")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_LF.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Lumos")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_Lumos.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Robo Race")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_RR.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Robo Soccer")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_Rs.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Biz Quiz")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_BizQ.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Tech Quiz")) {
                    Intent i = new Intent(ListEvents.this, TabActivity_TechQ.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("IUPC")) {
                    Intent i = new Intent(ListEvents.this, Tab_IUPC.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Distraction IUPC")) {
                    Intent i = new Intent(ListEvents.this, Tab_diupc.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Fix the Bug")) {
                    Intent i = new Intent(ListEvents.this, Tab_fib.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Asgard")) {
                    Intent i = new Intent(ListEvents.this, Tab_Asgard.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Astro Hunt")) {
                    Intent i = new Intent(ListEvents.this, Tab_AH.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Into the Universe")) {
                    Intent i = new Intent(ListEvents.this, Tab_itu.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Finders Keeper")) {
                    Intent i = new Intent(ListEvents.this, Tab_fk.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Lyrewrite")) {
                    Intent i = new Intent(ListEvents.this, Tab_lw.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Floor Crossing")) {
                    Intent i = new Intent(ListEvents.this, Tab_fc.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("TurnCoat")) {
                    Intent i = new Intent(ListEvents.this, Tab_tc.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Negotio")) {
                    Intent i = new Intent(ListEvents.this, Tab_nego.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                } else if (modelEvents.name.equals("Startup Intern Fair")) {
                    Intent i = new Intent(ListEvents.this, Tab_sif.class);
                    i.putExtra("colorprimary",primaryColor);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status);
                    i.putExtra("model", modelEventsArrayList);
                    startActivity(i);
                }
            }
        }
        ));


    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_txt = (TextView)findViewById(R.id.texttoolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.parseColor(status));
            }
            toolbar.setBackgroundColor(Color.parseColor(primaryColor));
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar_txt.setText("List Of Events");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(ListEvents.this, MainActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}
