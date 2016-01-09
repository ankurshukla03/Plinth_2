package lnmiit.madclub.plinth.NavigationDrawerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/9/2016.
 */
public class Developer extends Fragment {

    public Developer() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developer,container,false);



        return view;
    }
}
