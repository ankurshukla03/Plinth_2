package lnmiit.madclub.plinth.NavigationDrawerFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Adapter.ScheduleAdapter;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.Widget.RecyclerItemClickListener;

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
    String day1 = "https://docs.google.com/document/d/16KLhqRbPalxw7-pcJspbscmN2Ru9yVQ0I7CMqKYSABM/edit?ts=569d5197";
    String day2 = "https://docs.google.com/document/d/1-f0L_ebPUWAe9FgOAyWivBy4ZY76gwXEtgodsRc8xUk/edit?ts=569d521b";
    String day3 = "https://docs.google.com/document/d/1-zehvZWeFB8MkSwvkzJQGQWU9EfzhCxdj3kirmI-Q30/edit";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        day.clear();
        day.add(day_s[0]);
        day.add(day_s[1]);
        day.add(day_s[2]);
        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ScheduleAdapter(day,getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new
                RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String temp = day.get(position);
                if(temp.equals("Day 1")){
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(day1));
                    startActivity(i);
                }else if(temp.equals("Day 2")){
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(day2));
                    startActivity(i);
                }else{
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(day3));
                    startActivity(i);
                }

            }
        }
        ));

        return view;
    }
}
