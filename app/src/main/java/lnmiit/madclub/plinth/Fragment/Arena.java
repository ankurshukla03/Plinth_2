package lnmiit.madclub.plinth.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/4/2016.
 */
public class Arena extends Fragment {


    int type;
    public Arena() {
    }
    public Arena(int type) {
        this.type=type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_arena,container,false);



        return view;
    }
}
