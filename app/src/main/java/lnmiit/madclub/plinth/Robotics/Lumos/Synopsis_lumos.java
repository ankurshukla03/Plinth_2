package lnmiit.madclub.plinth.Robotics.Lumos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/7/2016.
 */
public class Synopsis_lumos extends Fragment {

    public Synopsis_lumos() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.synopsis_trans,container,false);
        WebView webView;
        ImageView imageView;
        imageView = (ImageView)view.findViewById(R.id.synp_image_robotics);
        imageView.setImageResource(R.drawable.lumos);
        webView = (WebView)view.findViewById(R.id.webview_synp_trans);

        webView.loadUrl("file:///android_asset/Lumos_Synopsis.html");


        return view;
    }
}