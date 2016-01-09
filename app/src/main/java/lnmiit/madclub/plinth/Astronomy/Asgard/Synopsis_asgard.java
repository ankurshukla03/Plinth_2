package lnmiit.madclub.plinth.Astronomy.Asgard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/8/2016.
 */
public class Synopsis_asgard extends Fragment {

    public Synopsis_asgard() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_synopsis, container, false);

        WebView wv;
        ImageView imageView;
        imageView = (ImageView)v.findViewById(R.id.image_main);
        imageView.setImageResource(R.drawable.asgard);
        wv = (WebView)v.findViewById(R.id.webview_synp);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/Asgard_Synopsis.html");

        return v;
    }
}