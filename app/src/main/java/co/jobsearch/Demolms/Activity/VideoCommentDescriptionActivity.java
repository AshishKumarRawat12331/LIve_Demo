package co.jobsearch.Demolms.Activity;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import co.jobsearch.Demolms.Adapter.ContectDetailListByIdAdapter;
import co.jobsearch.Demolms.ApiRespose.PartsChannelVideo;
import co.jobsearch.Demolms.Fragment.SubFragment.CoursesContentFragment;
import co.jobsearch.Demolms.Fragment.SubFragment.VideoCommentFragment;
import co.jobsearch.Demolms.Fragment.SubFragment.VideoDescriptionFragment;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.Channelsub;
import co.jobsearch.Demolms.Utils.FragmentActivityMessage;
import co.jobsearch.Demolms.Utils.GlobalBus;
import co.jobsearch.Demolms.Utils.Loader;
import co.jobsearch.Demolms.Utils.UtilMethods;
import co.jobsearch.Demolms.YoutubeVideoPlayNew;

public class VideoCommentDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    String response;
    PartsChannelVideo operator;
    TextView Comment_tv,description_tv,subvategory_tv;
    Loader loader;
    String youtubelink;
    TextView tittle ;
    ImageView fullscreen_button;
    ImageView video_imahe;
    RelativeLayout play_video;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_video_part_description);


        Getid();


        //CoursesContentFragment

    }

    private void Getid() {

        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);
        play_video = findViewById(R.id.play_video);

        video_imahe = findViewById(R.id.video_imahe);
        fullscreen_button = findViewById(R.id.fullscreen_button);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
         play_video.setOnClickListener(this);

        fullscreen_button.setOnClickListener(this);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Video");
        toolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Comment_tv=findViewById(R.id.Comment_tv);
        description_tv=findViewById(R.id.description_tv);
        subvategory_tv=findViewById(R.id.subvategory_tv);
        Comment_tv.setOnClickListener(this);
        description_tv.setOnClickListener(this);
        subvategory_tv.setOnClickListener(this);
        tittle=findViewById(R.id.tittle);
        tittle.setOnClickListener(this);

        response=getIntent().getStringExtra("response");

        Gson gson = new Gson();
        operator = gson.fromJson(response, PartsChannelVideo.class);
        tittle.setText("  "+operator.getTitle() );

        Log.e("Description",""+ operator.getDescription());

        UtilMethods.INSTANCE.part_description(this,""+operator.getDescription());
        UtilMethods.INSTANCE.Get_part_video_id(this,operator.getId()+""  );

        // Toast.makeText(this, ""+operator.getId(), Toast.LENGTH_SHORT).show();

        //  data_priseList( prisedetail);
        //    UtilMethods.INSTANCE.Get_Course_id(this,operator.getId()+"" ,""+response );
        //   UtilMethods.INSTANCE.DemoVideocontentdetails(this,operator.getId()+"",null);

        final String videolinkre=""+ operator.getUpload_video().replace("https://youtu.be/","");
        String img_url="http://img.youtube.com/vi/"+videolinkre.replace("?t=6","")+"/0.jpg"; // this is link which will give u thumnail image of that video

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.rnd_logo);
        requestOptions.error(R.drawable.rnd_logo);

        Glide.with(this)
                .load( ""+img_url)
                .apply(requestOptions)
                .into(video_imahe);

        subvategory_tv.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

      //  Comment_tv.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

        description_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
        Comment_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
        Comment_tv.setTextColor(getResources().getColorStateList(R.color.black));
        subvategory_tv.setTextColor(getResources().getColorStateList(R.color.white));

        description_tv.setTextColor(getResources().getColorStateList(R.color.black));


        // subvategory_tv.setTextColor(getResources().getColorStateList(R.color.black));
        //  changeFragment(new VideoCommentFragment());

        changeFragment(new CoursesContentFragment());




    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            GlobalBus.getBus().register(this);
        }
    }

    @Subscribe
    public void onFragmentActivityMessage(FragmentActivityMessage activityFragmentMessage) {



        if (activityFragmentMessage.getFrom().equalsIgnoreCase("Successful")) {


        }


    }

    ContectDetailListByIdAdapter mAdapter_content;
    ArrayList<PartsChannelVideo> transactionscontent = new ArrayList<>();
    Channelsub contenttransactions = new Channelsub();



    private void changeFragment(Fragment targetFragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }


    @Override
    public void onClick(View view) {

        if(view==play_video){

            youtubelink=""+ operator.getUpload_video().toString().trim();
            Intent i = new Intent(this, YoutubeVideoPlayNew.class);
            i.putExtra("video_id",""+youtubelink);
            startActivity(i);


        }

        if(view==Comment_tv){

            FragmentManager fragmentManager = getSupportFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            final CoursesContentFragment myFragment = new CoursesContentFragment();

              Comment_tv.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
              description_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
              subvategory_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
              Comment_tv.setTextColor(getResources().getColorStateList(R.color.white));
              description_tv.setTextColor(getResources().getColorStateList(R.color.black));
              subvategory_tv.setTextColor(getResources().getColorStateList(R.color.black));

            changeFragment(new VideoCommentFragment());


        }

        if(view==description_tv){

            description_tv.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
            Comment_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
            description_tv.setTextColor(getResources().getColorStateList(R.color.white));
            Comment_tv.setTextColor(getResources().getColorStateList(R.color.black));

            changeFragment(new VideoDescriptionFragment());


        }

        if(view==subvategory_tv){

            description_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
            subvategory_tv.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
            Comment_tv.setBackgroundTintList(getResources().getColorStateList(R.color.white));
            description_tv.setTextColor(getResources().getColorStateList(R.color.black));
            subvategory_tv.setTextColor(getResources().getColorStateList(R.color.white));
            Comment_tv.setTextColor(getResources().getColorStateList(R.color.black));

            changeFragment(new CoursesContentFragment());


        }


    }

}