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
public class ProblemStatement extends Fragment {

    int type;
    private WebView wv;

    public ProblemStatement() {
    }
    @SuppressLint("ValidFragment")
    public ProblemStatement(int type) {
        this.type=type;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_problemstatemnt, container, false);
        wv = (WebView)view.findViewById(R.id.webview_ps);
        switch (type)
        {
            case -6:
                wv.loadUrl("file:///android_asset/Transporter_PS.html");
                break;
            case -5:
                wv.loadUrl("file:///android_asset/Robowar_PS.html");
                break;
            case -4:
                wv.loadUrl("file:///android_asset/Linefollower_PS.html");
                break;
            case -3:
                wv.loadUrl("file:///android_asset/Lumos_PS.html");
                break;
            case -2:
                wv.loadUrl("file:///android_asset/Roborace_PS.html");
                break;
            case -1:
                wv.loadUrl("file:///android_asset/Robsoccer_PS.html");
                break;
            case 0:
                wv.loadUrl("file:///android_asset/BizQuiz_PS.html");
                break;
            case 1:
                wv.loadUrl("file:///android_asset/TechQuiz_PS.html");
                break;
            case 2:
                wv.loadUrl("file:///android_asset/Negotio_EventDescription.html");
                break;
            case 3:
                wv.loadUrl("file:///android_asset/SIF_EventDescription.html");
                break;
            case 4:
                wv.loadUrl("file:///android_asset/FindersKeepers_PS.html");
                break;
            case 5:
                wv.loadUrl("file:///android_asset/Lyrewrite_PS.html");
                break;
            case 6:
                wv.loadUrl("file:///android_asset/FloorCrossing_PS.html");
                break;
            case 7:
                wv.loadUrl("file:///android_asset/TurnCoat_PS.html");
                break;
            case 8:
                wv.loadUrl("file:///android_asset/Astrohunt_PS.html");
                break;
            case 9:
                wv.loadUrl("file:///android_asset/Asgard_PS.html");
                break;
            case 10:
                wv.loadUrl("file:///android_asset/IntoTheUniverse_PS.html");
                break;
            case 11:
                wv.loadUrl("file:///android_asset/IUPC_PS.html");
                break;
            case 12:
                wv.loadUrl("file:///android_asset/DistractionIUPC_PS.html");
                break;
            case 13:
                wv.loadUrl("file:///android_asset/FixTheBug_PS.html");
                break;
            case 14:
                wv.loadUrl("file:///android_asset/Workshops/DataScienece_WorkshopContent.html");
                break;
            case 15:
                wv.loadUrl("file:///android_asset/Workshops/IOT_WorkshopContent.html");
                break;
            case 16:
                wv.loadUrl("file:///android_asset/Workshops/Vision_WorkshopContent.html");
                break;
            case 17:
                wv.loadUrl("file:///android_asset/Workshops/EHacking_WorkshopContent.html");
                break;

        }
        return view ;
    }
}
