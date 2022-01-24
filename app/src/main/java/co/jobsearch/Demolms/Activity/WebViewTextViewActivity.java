package co.jobsearch.Demolms.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.jobsearch.Demolms.R;


public class WebViewTextViewActivity extends AppCompatActivity {

    WebView webview;
    String heading="";
    String description="";
    private int totleTime = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__text_web_view);

        heading=getIntent().getStringExtra("heading");
        description=getIntent().getStringExtra("description");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle(""+heading);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        webview=(WebView)findViewById(R.id.webview);

        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadDataWithBaseURL(null, description, "text/html", "utf-8", null);


        /* webview.loadUrl(""+ApplicationConstant.INSTANCE.baseUrl +"/About.html");*/

        Handler oneSecHandler = new Handler();

        oneSecHandler.postDelayed(timerRunnable, 1000);


    }



    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {

            totleTime++;
            int p1 = totleTime % 60;
            int p2 = totleTime / 60;
            int p3 = p2 % 60;
            p2 = p2 / 60;

            String sec;
            String hour;
            String min;
            if (p1 < 10) {
                sec = "0" + p1;
            } else {
                sec = String.valueOf(p1);
            }
            if (p2 < 10) {
                hour = "0" + p2;
            } else {
                hour = String.valueOf(p2);
            }
            if (p3 < 10) {
                min = "0" + p3;
            } else {
                min = String.valueOf(p3);
            }


            Log.e("timesetttttt","  hour   :   "+  hour  +"   ,  sec   :   "+  sec+"   min   :   "+ min  );


        }
    };




 }
