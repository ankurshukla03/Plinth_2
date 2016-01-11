package lnmiit.madclub.plinth.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/1/2016.
 */
public class Rules extends Fragment {

    int type;
    private WebView wv;
    public Rules() {
    }
    @SuppressLint("ValidFragment")
    public Rules(int type) {
        this.type=type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rules, container, false);
        wv = (WebView)view.findViewById(R.id.webView_rules);
        switch (type)
        {
            case -6:
                wv.loadUrl("file:///android_asset/Transporter_Rules.html");
                break;
            case -5:
                wv.loadUrl("file:///android_asset/Robowar_Rules.html");
                break;
            case -4:
                wv.loadUrl("file:///android_asset/Linefollower_Rules.html");
                break;
            case -3:
                wv.loadUrl("file:///android_asset/Lumos_Rules.html");
                break;
            case -2:
                wv.loadUrl("file:///android_asset/Roborace_Rules.html");
                break;
            case -1:
                wv.loadUrl("file:///android_asset/Robsoccer_Rules.html");
                break;
            case 0:
                wv.loadUrl("file:///android_asset/BizQuiz_Rules.html");
                break;
            case 1:
                wv.loadUrl("file:///android_asset/TechQuiz_Rules.html");
                break;
            case 2:
                wv.loadUrl("file:///android_asset/Negotio_Rules.html");
                break;
            case 3:
                wv.loadUrl("file:///android_asset/SIF_Rules.html");
                break;
            case 4:
                wv.loadUrl("file:///android_asset/FindersKeepers_Rules.html");
                break;
            case 5:
                wv.loadUrl("file:///android_asset/Lyrewrite_Rules.html");
                break;
            case 6:
                wv.loadUrl("file:///android_asset/FloorCrossing_Rules.html");
                break;
            case 7:
                wv.loadUrl("file:///android_asset/TurnCoat_Rules.html");
                break;
            case 8:
                wv.loadUrl("file:///android_asset/Astrohunt_Rules.html");
                break;
            case 9:
                wv.loadUrl("file:///android_asset/Asgard_Rules.html");
                break;
            case 10:
                wv.loadUrl("file:///android_asset/IntoTheUniverse_Rules.html");
                break;
            case 11:
                wv.loadUrl("file:///android_asset/IUPC_Rules.html");
                break;
            case 12:
                wv.loadUrl("file:///android_asset/DistractionIUPC_Rules.html");
                break;
            case 13:
                wv.loadUrl("file:///android_asset/FixTheBug_Rules.html");
                break;
            case 14:
                wv.loadUrl("file:///android_asset/FixTheBug_Rules.html");
                break;
            case 15:
                wv.loadUrl("file:///android_asset/FixTheBug_Rules.html");
                break;
            case 16:
                wv.loadUrl("file:///android_asset/FixTheBug_Rules.html");
                break;
            case 17:
                wv.loadUrl("file:///android_asset/FixTheBug_Rules.html");
                break;

        }

        return view;
    }
}
