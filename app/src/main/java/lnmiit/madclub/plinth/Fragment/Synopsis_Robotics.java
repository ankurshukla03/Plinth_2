package lnmiit.madclub.plinth.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/7/2016.
 */
public class Synopsis_Robotics extends Fragment {

    private ImageView image;
    private TextView prize_money;
    private WebView webView_synp_robo;

    public Synopsis_Robotics() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.synopsis_trans,container,false);
        image = (ImageView)view.findViewById(R.id.synp_image_robotics);
        prize_money = (TextView)view.findViewById(R.id.prize_money_text);
      //  webView_synp_robo = (WebView)view.findViewById(R.id.webview_synp_robotics);


        return view;
    }
}
