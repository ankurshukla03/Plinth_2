package lnmiit.madclub.plinth.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/4/2016.
 */
public class Arena extends Fragment {


    int type;
    public Arena() {
    }
    @SuppressLint("ValidFragment")
    public Arena(int type) {
        this.type=type;
    }

    ImageView arena;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_arena,container,false);
        arena = (ImageView)view.findViewById(R.id.arena);
        switch (type)
        {
            case -6:
                arena.setImageResource(R.drawable.ar_transporter);
                break;
            case -5:
                arena.setImageResource(R.drawable.ar_robowar);
                break;
            case -4:
                arena.setImageResource(R.drawable.ar_lfr);
                break;
            case -3:
                arena.setImageResource(R.drawable.ar_lumos);
                break;
            case -1:
                arena.setImageResource(R.drawable.ar_robosoccer);
                break;
        }


        return view;
    }
}
