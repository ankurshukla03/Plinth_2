package lnmiit.madclub.plinth.Fragment;

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
public class Synopsis_Robotics extends Fragment {

    int type;
    WebView webView;
    ImageView imageView;
    TextView textView;
    public Synopsis_Robotics() {
    }
    public Synopsis_Robotics(int type) {
        this.type=type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_synopsis_robotics,container,false);
        imageView = (ImageView)view.findViewById(R.id.synp_image_robotics);
        webView = (WebView)view.findViewById(R.id.webview_synp_trans);
        textView = (TextView)view.findViewById(R.id.prize_money_text);
        switch (type)
        {
            case -6:
                imageView.setImageResource(R.drawable.transporter);
                textView.setText("Rs 25,000");
                webView.loadUrl("file:///android_asset/Transporter_Synopsis.html");
                break;
            case -5:
                imageView.setImageResource(R.drawable.robowar);
                textView.setText("Rs 60,000");
                webView.loadUrl("file:///android_asset/Robowar_Synopsis.html");
                break;
            case -4:
                imageView.setImageResource(R.drawable.linefollower);
                textView.setText("Rs 25,000");
                webView.loadUrl("file:///android_asset/Linefollower_Synopsis.html");
                break;
            case -3:
                imageView.setImageResource(R.drawable.lumos);
                textView.setText("Rs 25,000");
                webView.loadUrl("file:///android_asset/Lumos_Synopsis.html");
                break;
            case -2:
                imageView.setImageResource(R.drawable.roborace);
                textView.setText("Rs 25,000");
                webView.loadUrl("file:///android_asset/Roborace_Synopsis.html");
                break;
            case -1:
                imageView.setImageResource(R.drawable.robosoccer);
                textView.setText("Rs 25,000");
                webView.loadUrl("file:///android_asset/Robosoccer_Synopsis.html");
                break;
        }
        return view;
    }
}