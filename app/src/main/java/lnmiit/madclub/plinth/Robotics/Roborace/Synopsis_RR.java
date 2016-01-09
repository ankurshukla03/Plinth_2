package lnmiit.madclub.plinth.Robotics.Roborace;

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
public class Synopsis_RR extends Fragment {

    public Synopsis_RR() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.synopsis_trans,container,false);
        WebView webView;
        ImageView imageView;
        imageView = (ImageView)view.findViewById(R.id.synp_image_robotics);
        imageView.setImageResource(R.drawable.roborace);
        webView = (WebView)view.findViewById(R.id.webview_synp_trans);
        webView.loadUrl("file:///android_asset/Roborace_Synopsis.html");
        TextView textView;
        textView = (TextView)view.findViewById(R.id.prize_money_text);
        textView.setText("Rs 25,000");

        return view;
    }
}