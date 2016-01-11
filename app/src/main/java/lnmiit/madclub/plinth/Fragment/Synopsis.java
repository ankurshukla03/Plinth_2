package lnmiit.madclub.plinth.Fragment;

import android.annotation.SuppressLint;
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
public class Synopsis extends Fragment {

    int type;
    public Synopsis() {
    }
    @SuppressLint("ValidFragment")
    public Synopsis(int type) {
        this.type=type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_synopsis, container, false);

        WebView wv;
        ImageView imageView;
        imageView = (ImageView)v.findViewById(R.id.image_main);
        wv = (WebView)v.findViewById(R.id.webview_synp);
        switch (type)
        {
            case 0:
                imageView.setImageResource(R.drawable.bizq);
                wv.loadUrl("file:///android_asset/BizQuiz_Synopsis.html");
                break;
            case 1:
                imageView.setImageResource(R.drawable.techq);
                wv.loadUrl("file:///android_asset/TechQuiz_Synopsis.html");
                break;
            case 2:
                imageView.setImageResource(R.drawable.bplan);
                wv.loadUrl("file:///android_asset/Negotio_Synopsis.html");
                break;
            case 3:
                imageView.setImageResource(R.drawable.sif);
                wv.loadUrl("file:///android_asset/SIF_Synopsis.html");
                break;
            case 4:
                imageView.setImageResource(R.drawable.finderskeepers);
                wv.loadUrl("file:///android_asset/FindersKeepers_Synopsis.html");
                break;
            case 5:
                imageView.setImageResource(R.drawable.lyre);
                wv.loadUrl("file:///android_asset/Lyrewrite_Synopsis.html");
                break;
            case 6:
                imageView.setImageResource(R.drawable.floorcrossing);
                wv.loadUrl("file:///android_asset/FloorCrossing_Synopsis.html");
                break;
            case 7:
                imageView.setImageResource(R.drawable.turncoat);
                wv.loadUrl("file:///android_asset/TurnCoat_Synopsis.html");
                break;
            case 8:
                imageView.setImageResource(R.drawable.astro);
                wv.loadUrl("file:///android_asset/Astrohunt_Synopsis.html");
                break;
            case 9:
                imageView.setImageResource(R.drawable.asgard);
                wv.loadUrl("file:///android_asset/Asgard_Synopsis.html");
                break;
            case 10:
                imageView.setImageResource(R.drawable.into);
                wv.loadUrl("file:///android_asset/IntoTheUniverse_Synopsis.html");
                break;
            case 11:
                imageView.setImageResource(R.drawable.iupc);
                wv.loadUrl("file:///android_asset/IUPC_Synopsis.html");
                break;
            case 12:
                imageView.setImageResource(R.drawable.diupc);
                wv.loadUrl("file:///android_asset/DistractionIUPC_Synopsis.html");
                break;
            case 13:
                imageView.setImageResource(R.drawable.fixtb);
                wv.loadUrl("file:///android_asset/FixTheBug_Synopsis.html");
                break;
            case 14:
                imageView.setImageResource(R.drawable.w1);
                wv.loadUrl("file:///android_asset/Workshops/DataScienece_Home.html");
                break;
            case 15:
                imageView.setImageResource(R.drawable.w2);
                wv.loadUrl("file:///android_asset/Workshops/IOT_Home.html");
                break;
            case 16:
                imageView.setImageResource(R.drawable.w3);
                wv.loadUrl("file:///android_asset/Workshops/Vision_Home.html");
                break;
            case 17:
                imageView.setImageResource(R.drawable.w4);
                wv.loadUrl("file:///android_asset/Workshops/EHacking_Home.html");
                break;
        }


        return v;
    }
}
