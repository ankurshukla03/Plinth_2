package lnmiit.madclub.plinth.NavigationDrawerFragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lnmiit.madclub.plinth.Activity.ListEvents;
import lnmiit.madclub.plinth.Activity.Talks;
import lnmiit.madclub.plinth.Adapter.GridAdapter;
import lnmiit.madclub.plinth.Model.ModelEvents;
import lnmiit.madclub.plinth.Model.ModelGrid;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.Widget.RecyclerItemClickListener;

/**
 * Created by Ankur Shukla on 12/31/2015.
 */
public class Home extends android.support.v4.app.Fragment {

    public static int[] typesimages={R.drawable.workshops,R.drawable.talks,R.drawable.robotics,R.drawable.quiz,R.drawable.ecell,
            R.drawable.literary,R.drawable.astronomy,R.drawable.coding};
    public static String[] typesnames={"WORKSHOPS","TALKS","ROBOTICS","QUIZ","E-CELL","LITERARY",
            "ASTRONOMY","CODING"};

    ArrayList<ModelGrid> modelGridArrayList = new ArrayList<>();
    List<String> robo ,astronomy,quiz,e_cell,coding,literary,workshop;
    TypedArray robo_image,quiz_image,literary_image,astro_image,coding_image,ecell_image,workshop_image;
    List<String> textback_color,secondary_color_status,status;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    String colorprimary,secondaryColor,status_color;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        
        addarray();
        intialize();
        View v = inflater.inflate(R.layout.fragment_home,null);
        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // The number of Columns
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // inflating the list
        mAdapter = new GridAdapter(modelGridArrayList,getActivity());
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.addOnItemTouchListener(new
                RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ModelGrid modelGrid = modelGridArrayList.get(position);
                ArrayList<ModelEvents> temp = modelGrid.eventsArrayList;
                colorprimary = modelGrid.color;
                secondaryColor = modelGrid.colorDark;
                status_color = modelGrid.status_color;
                if(modelGrid.name.equals("TALKS")){
                    Intent i = new Intent(getActivity(),Talks.class);
                    String talk_primary = "#"+textback_color.get(7);
                    String talk_status = "#"+status.get(7);
                    i.putExtra("colorprimary",talk_primary);
                    i.putExtra("status",talk_status);
                    startActivity(i);
                }else {
                    Intent i = new Intent(getActivity(), ListEvents.class);
                    i.putExtra("model", temp);
                    i.putExtra("colorprimary",colorprimary);
                    i.putExtra("secondarycolor",secondaryColor);
                    i.putExtra("status",status_color);
                    startActivity(i);
                }
            }
        }
        ));

        return v;
    }

    private void intialize(){
        for(int i =0;i<typesnames.length;i++){
            ModelGrid modelGrid = new ModelGrid();
            modelGrid.name = typesnames[i];
            modelGrid.image = typesimages[i];
            modelGrid.eventsArrayList= addarraylist(i);
            modelGrid.color = "#"+textback_color.get(i);
            modelGrid.colorDark = "#"+secondary_color_status.get(i);
            modelGrid.status_color = "#"+status.get(i);
            modelGridArrayList.add(modelGrid);
        }
    }


    private ArrayList<ModelEvents> addarraylist(int i){
        ArrayList<ModelEvents> modelEventsArrayList = new ArrayList<>();
        if(i == 2) {
            for (int j = 0; j < robo.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = robo.get(j);
                modelEvents.image = robo_image.getResourceId(j, 0);
                modelEvents.flag = 1;
                modelEventsArrayList.add(modelEvents);
            }
        }else if(i == 3){
            for (int j = 0; j < quiz.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = quiz.get(j);
                modelEvents.image = quiz_image.getResourceId(j, 0);
                modelEvents.flag = 6;
                modelEventsArrayList.add(modelEvents);
            }
        }else if(i == 4){
            for (int j = 0; j < e_cell.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = e_cell.get(j);
                modelEvents.image = ecell_image.getResourceId(j, 0);
                modelEvents.flag = 6;
                modelEventsArrayList.add(modelEvents);
            }
        }else if(i == 5){
            for (int j = 0; j < literary.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = literary.get(j);
                modelEvents.image = literary_image.getResourceId(j, 0);
                modelEvents.flag = 6;
                modelEventsArrayList.add(modelEvents);
            }
        }else if(i == 6){
            for (int j = 0; j < astronomy.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = astronomy.get(j);
                modelEvents.image = astro_image.getResourceId(j, 0);
                modelEvents.flag = 6;
                modelEventsArrayList.add(modelEvents);
            }
        }else if(i == 7){
            for (int j = 0; j < coding.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = coding.get(j);
                modelEvents.image =coding_image.getResourceId(j,0);
                modelEvents.flag = 6;
                modelEventsArrayList.add(modelEvents);
            }
        }
        else if(i == 0){
            for (int j = 0; j < workshop.size(); j++) {
                ModelEvents modelEvents = new ModelEvents();
                modelEvents.name = workshop.get(j);
                modelEvents.image = workshop_image.getResourceId(j,0);
                modelEvents.flag = 6;
                modelEventsArrayList.add(modelEvents);
            }
        }
       return  modelEventsArrayList;
    }

    private void addarray(){
        robo = Arrays.asList(getResources().getStringArray(R.array.robotics_list));
        quiz = Arrays.asList(getResources().getStringArray(R.array.quiz_list));
        e_cell = Arrays.asList(getResources().getStringArray(R.array.e_cell_list));
        astronomy = Arrays.asList(getResources().getStringArray(R.array.astronomy_list));
        coding = Arrays.asList(getResources().getStringArray(R.array.coding_list));
        literary = Arrays.asList(getResources().getStringArray(R.array.literary_list));
        robo_image = getResources().obtainTypedArray(R.array.robo_image);
        literary_image = getResources().obtainTypedArray(R.array.literary_image);
        coding_image = getResources().obtainTypedArray(R.array.coding_image);
        astro_image = getResources().obtainTypedArray(R.array.astronomy_image);
        ecell_image = getResources().obtainTypedArray(R.array.e_cell_image);
        quiz_image  = getResources().obtainTypedArray(R.array.quiz_image);
        textback_color = Arrays.asList(getResources().getStringArray(R.array.text_color));
        secondary_color_status = Arrays.asList(getResources().getStringArray(R.array.secondary_color));
        status = Arrays.asList(getResources().getStringArray(R.array.status_color));
        workshop = Arrays.asList(getResources().getStringArray(R.array.workshop_name));
        workshop_image = getResources().obtainTypedArray(R.array.workshop_image);
    }

}
