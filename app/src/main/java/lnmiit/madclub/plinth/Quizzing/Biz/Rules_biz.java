package lnmiit.madclub.plinth.Quizzing.Biz;

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
public class Rules_biz extends Fragment {

    private WebView webView_rules;
    public Rules_biz() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rules, container, false);
        webView_rules = (WebView)view.findViewById(R.id.webView_rules);
        webView_rules.loadUrl("file:///android_asset/BizQuiz_Rules.html");
        return view;
    }
}