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

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.jobsearch.Demolms.Activity.QuizActivity;
import co.jobsearch.Demolms.Activity.WebViewTextViewdetaTimeCountActivity;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.YoutubeVideoPlayNew;


/**
 * Created by Uzair khan on 18-04-2020.
 */

public class PartVidetextSubSubAdapter extends RecyclerView.Adapter<PartVidetextSubSubAdapter.MyViewHolder> {

    private ArrayList<SubHeadingDatum> transactionsList;
    private Context mContext;
    String response="";


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RelativeLayout headerContent;
        ImageView playyyy;

        public MyViewHolder(View view) {
            super(view);

            title =  view.findViewById(R.id.title);
            headerContent =  view.findViewById(R.id.headerContent);
            playyyy =  view.findViewById(R.id.playyyy);

        }
    }

    public PartVidetextSubSubAdapter(ArrayList<SubHeadingDatum> transactionsList, Context mContext , String response) {

        this.transactionsList = transactionsList;
        this.mContext = mContext;
        this.response = response;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_sub_sub_list_by_adapter, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final SubHeadingDatum operator = transactionsList.get(position);



        if(operator.getType().equalsIgnoreCase("quiz")){

            holder.title.setText("" + operator.getHeading());
            holder.playyyy.setImageDrawable(mContext.getResources().getDrawable(R.drawable.testquiz));

        }else if(operator.getType().equalsIgnoreCase("video")){

            holder.title.setText("" + operator.getTitle());
            holder.playyyy.setImageDrawable(mContext.getResources().getDrawable(R.drawable.playyyy));

        }else if(operator.getType().equalsIgnoreCase("text")){

            holder.title.setText("" + operator.getHeading());
            holder.playyyy.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_text_snippet_24));
        }


/*
        if(operator.getType().equalsIgnoreCase("video")){
            holder.headerContent.setVisibility(View.VISIBLE);
        }else {
            holder.headerContent.setVisibility(View.GONE);

        }*/

        holder.headerContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TypeType",""+ operator.getType() );

                if(operator.getType().equalsIgnoreCase("quiz")){

                    Intent i = new Intent(mContext, QuizActivity.class);
                    i.putExtra("Quiz_id",""+operator.getQuizeId());
                    mContext.startActivity(i);


                  //  holder.playyyy.setImageDrawable(mContext.getResources().getDrawable(R.drawable.testquiz));

                }else if(operator.getType().equalsIgnoreCase("video")){

                    Intent i = new Intent(mContext, YoutubeVideoPlayNew.class);
                    i.putExtra("video_id",""+""+ operator.getUploadVideo().toString().trim());
                    i.putExtra("contentid",""+operator.getId());

                    mContext.startActivity(i);


                }else if(operator.getType().equalsIgnoreCase("text")){

                    Intent i = new Intent(mContext, WebViewTextViewdetaTimeCountActivity.class);
                    i.putExtra("description",""+""+ operator.getDescription().toString().trim());
                    i.putExtra("heading","");
                    i.putExtra("contentid",""+operator.getId());
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