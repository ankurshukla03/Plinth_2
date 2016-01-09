package lnmiit.madclub.plinth.Coding.DIUPC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/8/2016.
 */
public class PS_diupc extends Fragment {

    private WebView webView_ps;

    public PS_diupc() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_problemstatemnt, container, false);
        webView_ps = (WebView)view.findViewById(R.id.webview_ps);
        webView_ps.loadUrl("file:///android_asset/DistractionIUPC_PS.html");
        return view ;
    }
}
