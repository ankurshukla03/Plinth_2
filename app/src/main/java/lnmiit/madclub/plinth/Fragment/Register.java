package lnmiit.madclub.plinth.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/1/2016.
 */
public class Register extends Fragment {


     Button button;
    public Register() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        button = (Button)view.findViewById(R.id.button);



        return view;
    }
}
