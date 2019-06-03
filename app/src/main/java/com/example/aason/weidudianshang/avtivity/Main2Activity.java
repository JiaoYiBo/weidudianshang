package com.example.aason.weidudianshang.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.aason.weidudianshang.R;

public class Main2Activity extends AppCompatActivity {
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wv = findViewById(R.id.wv);
        wv.loadUrl("http://172.17.8.100/htm/lottery/index.html");
        wv.getSettings().setJavaScriptEnabled(true);//可以和javaScript交互
        wv.setWebViewClient(new WebViewClient());
    }
}
