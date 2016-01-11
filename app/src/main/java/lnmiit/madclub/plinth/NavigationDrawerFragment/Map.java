package lnmiit.madclub.plinth.NavigationDrawerFragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import lnmiit.madclub.plinth.R;


/**
 * Created by Infinia on 29-11-2015.
 */
public class Map extends Fragment {

    WebView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_map,null);
        map = (WebView)v. findViewById(R.id.map);
        map.getSettings().setBuiltInZoomControls(true);
        map.getSettings().setDisplayZoomControls(false);
        map.getSettings().setUseWideViewPort(false);
        map.scrollTo(1260,700);
        map.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        map.setScrollbarFadingEnabled(false);
        map.loadUrl("file:///android_asset/map.html");
        return v;


    }
}
