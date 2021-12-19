package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MapsActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        getSupportActionBar().hide();

        webView = findViewById(R.id.webViewMap);
        webView.getSettings().setJavaScriptEnabled(true);


        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = manager.getActiveNetworkInfo();
        boolean hasConnect = (i!= null && i.isConnected() && i.isAvailable());

        if(hasConnect)
        {
            webView.loadUrl("https://www.google.com/maps/d/u/2/embed?mid=1hNSeISNVd_JapLr8WR2BVGVfCD3U3tmA");
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new WebViewClient());
        }
        else
        {
            Toast.makeText(MapsActivity.this, "No Internet Connection!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            finish();
        }
    }
}
