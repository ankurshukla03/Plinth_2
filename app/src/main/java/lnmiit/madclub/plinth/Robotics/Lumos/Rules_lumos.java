package lnmiit.madclub.plinth.Robotics.Lumos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/7/2016.
 */
public class Rules_lumos extends Fragment {

    public Rules_lumos() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.trans_rules,container,false);
        WebView webView;
        webView = (WebView)view.findViewById(R.id.webView_rules_trans);
        webView.loadUrl("file:///android_asset/Lumos_Rules.html");


        return view;
    }
}
