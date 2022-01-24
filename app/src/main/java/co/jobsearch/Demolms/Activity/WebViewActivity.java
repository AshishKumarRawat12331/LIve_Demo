package co.jobsearch.Demolms.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.Loader;

public class WebViewActivity extends AppCompatActivity {

    WebView webview;
    String url="";
    String name="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        url=getIntent().getStringExtra("url");
        name=getIntent().getStringExtra("name");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle(""+name);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




        webview=(WebView)findViewById(R.id.webview);
        final Loader loader = new Loader(WebViewActivity.this, android.R.style.Theme_Translucent_NoTitleBar);

        loader.show();
        loader.setCancelable(false);
        loader.setCanceledOnTouchOutside(false);

        webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {

                if (loader.isShowing()) {
                    loader.dismiss();
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }
        });
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(""+url);


        /* webview.loadUrl(""+ApplicationConstant.INSTANCE.baseUrl +"/About.html");*/


    }
}