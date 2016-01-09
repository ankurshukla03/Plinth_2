package lnmiit.madclub.plinth.NavigationDrawerFragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.madclub.plinth.R;

public class Workshops extends Fragment {

    public Workshops() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workshop,container,false);



        return view;
    }

}
