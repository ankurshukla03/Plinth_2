package lnmiit.madclub.plinth.Astronomy.Into_TheUniv;

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
public class Synopsis_itu extends Fragment {

    public Synopsis_itu() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_synopsis, container, false);

        WebView wv;
        ImageView imageView;
        imageView = (ImageView)v.findViewById(R.id.image_main);
        imageView.setImageResource(R.drawable.into);
        wv = (WebView)v.findViewById(R.id.webview_synp);
        wv.loadUrl("file:///android_asset/IntoTheUniverse_Synopsis.html");

        return v;
    }
}