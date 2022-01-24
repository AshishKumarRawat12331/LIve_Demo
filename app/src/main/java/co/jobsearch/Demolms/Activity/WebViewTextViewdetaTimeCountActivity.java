package co.jobsearch.Demolms.Activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;

import co.jobsearch.Demolms.ApiRespose.DataLogin;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.ApplicationConstant;
import co.jobsearch.Demolms.Utils.Loader;
import co.jobsearch.Demolms.Utils.UtilMethods;

public class WebViewTextViewdetaTimeCountActivity extends AppCompatActivity {

    WebView webview;
    String heading="";
    String description="";
    String partid="";
    private int totleTime = 0;
    Loader loader;
    TextView textViewcountdown;
    int time = 0;
    private Handler mHandler = new Handler();

    private void runtime() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ++time;
                if (time <= 9) {
                    textViewcountdown.setText("" + String.valueOf(time));
                } else {
                    textViewcountdown.setText("" + String.valueOf(time));
                }
                mHandler.postDelayed(this, 1000);

            }
        };

        mHandler.post(runnable);

    }

    @Override
    public void onBackPressed() {
        HitTime(textViewcountdown.getText().toString().trim()+"");

finish();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__text_web_view);

        // Timer here

        textViewcountdown = findViewById(R.id.timer_txt);

        runtime();

        heading=getIntent().getStringExtra("heading");
        description=getIntent().getStringExtra("description");
        partid=getIntent().getStringExtra("contentid");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle(""+heading);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

                HitTime(textViewcountdown.getText().toString().trim()+"");

                finish();

            }
        });

        webview=(WebView)findViewById(R.id.webview);
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadDataWithBaseURL(null, description, "text/html", "utf-8", null);



    }

    private void HitTime(String sec ) {

        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);
        loader.show();
        loader.setCancelable(false);
        loader.setCanceledOnTouchOutside(false);

        SharedPreferences myPreferences =  getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String contentid = myPreferences.getString(ApplicationConstant.INSTANCE.content_id, "");

        UtilMethods.INSTANCE.videoseen(this, contentid,  partid, textViewcountdown.getText().toString().trim()+"",loader);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
