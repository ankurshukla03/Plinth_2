package lnmiit.madclub.plinth.Robotics.Transporter;

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
public class PS_trans extends Fragment {

    public PS_trans() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trans_ps,container,false);
        WebView webView;
        webView = (WebView)view.findViewById(R.id.webview_ps_trans);
        webView.loadUrl("file:///android_asset/Transporter_PS.html");



        return view;
    }
}
