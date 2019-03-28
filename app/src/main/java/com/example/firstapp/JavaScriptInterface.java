package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;

public class JavaScriptInterface {

    AppCompatActivity jActivity;

    JavaScriptInterface(AppCompatActivity activity) {
        jActivity = activity;
    }

    @JavascriptInterface
    public void exit() {
        jActivity.finish();
        System.exit(0);
    }
}