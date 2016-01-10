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
        setContentView(R.layout.actvity_recylerview);

        setUpToolbar();

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_viewlist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(ListEvents.this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EventsAdapter(modelEventsArrayList,ListEvents.this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new
                RecyclerItemClickListener(ListEvents.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ModelEvents modelEvents = modelEventsArrayList.get(position);
                Intent i = new Intent(ListEvents.this, TabActivity.class);
                i.putExtra("colorprimary",primaryColor);
                i.putExtra("secondarycolor",secondaryColor);
                i.putExtra("status",status);
                i.putExtra("model", modelEventsArrayList);
                i.putExtra("type",modelEvents.name);
                startActivity(i);
               /* overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);*/
                finish();

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
            toolbar_txt.setText("Events");
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
