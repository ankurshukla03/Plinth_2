package lnmiit.madclub.plinth.Activity;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import lnmiit.madclub.plinth.NavigationDrawerFragment.Schedule;
import lnmiit.madclub.plinth.R;

public class ListSchedules extends AppCompatActivity {

    WebView webView;
    Toolbar toolbar;
    TextView toolbar_txt;
    String status = "#1976D2";
    String primaryColor = "#2196F3";
    String name;
    String day1 = "https://docs.google.com/document/d/16KLhqRbPalxw7-pcJspbscmN2Ru9yVQ0I7CMqKYSABM/edit?ts=569d5197";
    String day2 = "https://docs.google.com/document/d/1-f0L_ebPUWAe9FgOAyWivBy4ZY76gwXEtgodsRc8xUk/edit?ts=569d521b";
    String day3 = "https://docs.google.com/document/d/1-zehvZWeFB8MkSwvkzJQGQWU9EfzhCxdj3kirmI-Q30/edit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_list_schedules);


        webView = (WebView)findViewById(R.id.webview_Schedules);
        setUpToolbar();
        if(name.equals("Day 1")){
            startWebView(day1);
        }else if(name.equals("Day 2")){
            startWebView(day2);
        }else{
            startWebView(day3);
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_txt = (TextView)findViewById(R.id.texttoolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.parseColor(status));
            }
            toolbar.setBackgroundColor(Color.parseColor(primaryColor));
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar_txt.setText(name);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(ListSchedules.this, MainActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(ListSchedules.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);

        // Other webview options
        /*
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);
        */

        /*
         String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null);
         */

        //Load url in webview
        webView.loadUrl(url);


    }

}
