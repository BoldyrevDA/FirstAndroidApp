package com.example.firstapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    protected WebView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        game = (WebView) findViewById(R.id.game);

        // settings
        game.setWebViewClient(new WebViewClient());
        game.setInitialScale(1);
        game.getSettings().setUseWideViewPort(true);
        game.getSettings().setLoadWithOverviewMode(true);
        game.getSettings().setAllowContentAccess(true);
        game.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            game.getSettings().setAllowFileAccessFromFileURLs(true);
            game.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }
        game.getSettings().setJavaScriptEnabled(true);
        game.addJavascriptInterface(new JavaScriptInterface(this), "AndroidFunction");
        // load
        game.loadUrl("file:///android_asset/game/index.html");
    }
}
