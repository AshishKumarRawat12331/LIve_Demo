package co.jobsearch.Demolms.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

import co.jobsearch.Demolms.Activity.QuizActivity;
import co.jobsearch.Demolms.Activity.WebViewTextViewActivity;
import co.jobsearch.Demolms.Activity.WebViewTextViewdetaTimeCountActivity;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.YoutubeVideoPlayNew;

/**
 * Created by Uzair khan on 18-04-2020.
 */

public class PartVidetextSubAdapter extends RecyclerView.Adapter<PartVidetextSubAdapter.MyViewHolder> {

    private ArrayList<HeadingDatum> transactionsList;
    private Context mContext;
    String response="";

    PartVidetextSubSubAdapter mAdapter_content;
    ArrayList<SubHeadingDatum> transactionscontent = new ArrayList<>();
    HeadingDatum contenttransactions = new HeadingDatum();


    public class MyViewHolder extends RecyclerView.ViewHolder {
           TextView title,description;
            ImageView imagegetsub,im_imageleft;
            RecyclerView rc_subcat;
            RelativeLayout headerContent;

        public MyViewHolder(View view) {
            super(view);

            title =  view.findViewById(R.id.title);
            description =  view.findViewById(R.id.description);
            imagegetsub =  view.findViewById(R.id.imagegetsub);
            rc_subcat =  view.findViewById(R.id.rc_subcat);
            headerContent =  view.findViewById(R.id.headerContent);
            im_imageleft =  view.findViewById(R.id.im_imageleft);

        }
    }

    public PartVidetextSubAdapter(ArrayList<HeadingDatum> transactionsList, Context mContext , String response) {

        this.transactionsList = transactionsList;
        this.mContext = mContext;
        this.response = response;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_sub_list_by_adapter, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final HeadingDatum operator = transactionsList.get(position);

        if(operator.getType().equalsIgnoreCase("sub_heading")){

            holder.imagegetsub.setVisibility(View.VISIBLE);
            holder.title.setText("" + operator.getHeading());
            holder.im_imageleft.setImageDrawable(mContext.getResources().getDrawable(R.drawable.red_circle));

        }else if(operator.getType().equalsIgnoreCase("text")){

            holder.title.setText("" + operator.getHeading());
            holder.imagegetsub.setVisibility(View.GONE);
            holder.im_imageleft.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_text_snippet_24));

        }else if(operator.getType().equalsIgnoreCase("video")){

            holder.title.setText("" + operator.getTitle());
            holder.imagegetsub.setVisibility(View.GONE);
            holder.im_imageleft.setImageDrawable(mContext.getResources().getDrawable(R.drawable.playyyy));

        }else if(operator.getType().equalsIgnoreCase("quiz")){

            holder.imagegetsub.setVisibility(View.GONE);
            holder.title.setText("" + operator.getHeading());
            holder.im_imageleft.setImageDrawable(mContext.getResources().getDrawable(R.drawable.testquiz));

        }

        holder.headerContent.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if(operator.getType().equalsIgnoreCase("sub_heading")){

                     if(holder.rc_subcat.getVisibility()==View.VISIBLE){
                         holder.rc_subcat.setVisibility(View.GONE);
                         holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24));
                     }else {
                         holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24));
                         holder.rc_subcat.setVisibility(View.VISIBLE);
                     }

                     String Apiresponse="" + new Gson().toJson(operator).toString();
                     Gson gson = new Gson();
                     contenttransactions = gson.fromJson(Apiresponse, HeadingDatum.class);
                     transactionscontent = contenttransactions.getSubHeadingData();

                     if (transactionscontent.size() > 0) {
                         mAdapter_content = new PartVidetextSubSubAdapter(transactionscontent, mContext,Apiresponse );
                         holder.rc_subcat.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                         holder.rc_subcat.setItemAnimator(new DefaultItemAnimator());
                         holder.rc_subcat.setAdapter(mAdapter_content);
                         holder.rc_subcat.setNestedScrollingEnabled(false);

                     } else {
                         //  holder.rc_subcat.setVisibility(View.GONE);
                     }

                 }else if(operator.getType().equalsIgnoreCase("text")){

                     Intent i = new Intent(mContext, WebViewTextViewdetaTimeCountActivity.class);
                     i.putExtra("heading",""+ operator.getHeading().toString().trim());
                     i.putExtra("description",""+ operator.getDescription().toString().trim());
                     i.putExtra("contentid",""+operator.getId());

                     mContext.startActivity(i);

                 }else if(operator.getType().equalsIgnoreCase("video")){

                     Intent i = new Intent(mContext, YoutubeVideoPlayNew.class);
                     i.putExtra("video_id", ""+ operator.getUploadVideo().toString().trim());
                     i.putExtra("contentid",""+operator.getId());

                     mContext.startActivity(i);

                 }else if(operator.getType().equalsIgnoreCase("quiz")){

                     Intent i = new Intent(mContext, QuizActivity.class);
                     i.putExtra("Quiz_id",""+operator.getQuizeId());
                     mContext.startActivity(i);


                 }







             }
         });
    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

}