package lnmiit.madclub.plinth.NavigationDrawerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Adapter.EventsAdapter;
import lnmiit.madclub.plinth.Adapter.ScheduleAdapter;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/11/2016.
 */
public class Schedule extends Fragment {

    public Schedule() {
    }

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    String[] day_s = {"Day 1","Day 2","Day 3"};
    ArrayList<String> day = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        day.clear();
        day.add(day_s[0]);
        day.add(day_s[1]);
        day.add(day_s[2]);
        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_viewlist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ScheduleAdapter(day,getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
