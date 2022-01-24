package co.jobsearch.Demolms.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import co.jobsearch.Demolms.Activity.Course_Content_Description_Activity;
import co.jobsearch.Demolms.Activity.VideoCommentDescriptionActivity;
import co.jobsearch.Demolms.ApiRespose.PartsChannelVideo;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.ApplicationConstant;
import co.jobsearch.Demolms.Utils.Loader;
import co.jobsearch.Demolms.Utils.UtilMethods;

/**
 * Created by Uzair khan on 18-04-2020.
 */

public class PartVideoAdapter extends RecyclerView.Adapter<PartVideoAdapter.MyViewHolder> {

    private ArrayList<PartsChannelVideo> transactionsList;
    private Context mContext;
    String youtubelink;
    onItemClickListner onItemClickListner;


    public void filter(ArrayList<PartsChannelVideo> newlist) {

        transactionsList = new ArrayList<>();
        transactionsList.addAll(newlist);
        notifyDataSetChanged();


    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, cousetittle, cousername;
        ImageView image_post, imagecourse;
        RelativeLayout click_blog,relative_layout;


        public MyViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.title);

            imagecourse = view.findViewById(R.id.imagecourse);
            image_post = view.findViewById(R.id.image_post);
            cousername = view.findViewById(R.id.cousername);
            cousetittle = view.findViewById(R.id.cousetittle);
            click_blog = view.findViewById(R.id.click_blog);
            relative_layout = view.findViewById(R.id.relative_layout);

        }
    }

    public PartVideoAdapter(ArrayList<PartsChannelVideo> transactionsList, Context mContext) {

        this.transactionsList = transactionsList;
        this.mContext = mContext;


    }

    @Override
    public PartVideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.couress_part_list_adapter, parent, false);

        return new PartVideoAdapter.MyViewHolder(itemView);

    }

    public void setOnItemClickListner(PartVideoAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface onItemClickListner {
        void onClick(String str);//pass your object types.
    }

    @Override
    public void onBindViewHolder(final PartVideoAdapter.MyViewHolder holder, final int position) {
        final PartsChannelVideo operator = transactionsList.get(position);

        holder.cousetittle.setText("" + operator.getTitle());
        holder.cousername.setText("" + operator.getTitle());
        holder.title.setText("" + operator.getTitle());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(mContext, Course_Content_Description_Activity.class);
//            }
//        });


        final String videolinkre = "" + operator.getUpload_video().replace("https://youtu.be/", "");
        String img_url = "http://img.youtube.com/vi/" + videolinkre.replace("?t=6", "") + "/0.jpg"; // this is link which will give u thumnail image of that video

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.rnd_logo);
        requestOptions.error(R.drawable.rnd_logo);

        Glide.with(mContext)
                .load(img_url)
                .apply(requestOptions)
                .into(holder.imagecourse);


        holder.relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position != 0) {

                    int con_poss = position - 1;

                    Log.e("con_poss", "As : " + con_poss + "  position :  " + position);

                    SharedPreferences myPreferences = mContext.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, mContext.MODE_PRIVATE);
                    String contentid = myPreferences.getString(ApplicationConstant.INSTANCE.content_id, "");

                    Loader loader;
                    loader = new Loader(mContext, android.R.style.Theme_Translucent_NoTitleBar);
                    loader.show();
                    loader.setCancelable(false);
                    loader.setCanceledOnTouchOutside(false);

                    UtilMethods.INSTANCE.Videoopen(mContext, contentid, transactionsList.get(con_poss).getId(), operator, loader);

                } else {

                    Intent i = new Intent(mContext, Course_Content_Description_Activity.class);
//                   i.putExtra("response", ""+new Gson().toJson(operator).toString());
                    mContext.startActivity(i);

                }



                /*
                 */

                /*   youtubelink=""+ operator.getUpload_video().toString().trim();
                Intent i = new Intent(mContext, YoutubeVideoPlayNew.class);
                i.putExtra("video_id",""+youtubelink);
                mContext.startActivity(i);*/

                /* Intent i=new Intent(mContext, PlaySelectVideoNew.class);
                 i.putExtra("videoid",""+videolinkre.replace("?t=6",""));
                i.putExtra("discriptiom", ""+operator.getTitle() );
                i.putExtra("response", ""+"response");
                mContext.startActivity(i);*/


            }

        });

//        holder.click_blog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (position != 0) {
//
//                    int con_poss = position - 1;
//
//                    Log.e("con_poss", "As : " + con_poss + "  position :  " + position);
//
//                    SharedPreferences myPreferences = mContext.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, mContext.MODE_PRIVATE);
//                    String contentid = myPreferences.getString(ApplicationConstant.INSTANCE.content_id, "");
//
//                    Loader loader;
//                    loader = new Loader(mContext, android.R.style.Theme_Translucent_NoTitleBar);
//                    loader.show();
//                    loader.setCancelable(false);
//                    loader.setCanceledOnTouchOutside(false);
//
//                    UtilMethods.INSTANCE.Videoopen(mContext, contentid, transactionsList.get(con_poss).getId(), operator, loader);
//
//                } else {
//
////                    Intent i = new Intent(mContext, Course_Content_Description_Activity.class);
//////                   i.putExtra("response", ""+new Gson().toJson(operator).toString());
////                    mContext.startActivity(i);
//
//                }
//
//
//
//                /*
//                 */
//
//                /*   youtubelink=""+ operator.getUpload_video().toString().trim();
//                Intent i = new Intent(mContext, YoutubeVideoPlayNew.class);
//                i.putExtra("video_id",""+youtubelink);
//                mContext.startActivity(i);*/
//
//                /* Intent i=new Intent(mContext, PlaySelectVideoNew.class);
//                 i.putExtra("videoid",""+videolinkre.replace("?t=6",""));
//                i.putExtra("discriptiom", ""+operator.getTitle() );
//                i.putExtra("response", ""+"response");
//                mContext.startActivity(i);*/
//
//
//            }
//
//        });

    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

}