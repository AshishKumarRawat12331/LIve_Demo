package co.jobsearch.Demolms.Adapter;

import android.content.Context;
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

import co.jobsearch.Demolms.R;


/**
 * Created by Uzair khan on 18-04-2020.
 */

public class PartVidetextAdapter extends RecyclerView.Adapter<PartVidetextAdapter.MyViewHolder> {

    private ArrayList<MainDataRespose> transactionsList;
    private Context mContext;
    String response="";
    private int row_index=0;


    PartVidetextSubAdapter mAdapter_content;
    ArrayList<HeadingDatum> transactionscontent = new ArrayList<>();
    MainDataRespose contenttransactions = new MainDataRespose();




    public class MyViewHolder extends RecyclerView.ViewHolder {
           TextView title,description;
            ImageView imagegetsub;
            RecyclerView rc_subcat;
            RelativeLayout headerContent;

        public MyViewHolder(View view) {
            super(view);

            title =  view.findViewById(R.id.title);
            description =  view.findViewById(R.id.description);
            imagegetsub =  view.findViewById(R.id.imagegetsub);
            rc_subcat =  view.findViewById(R.id.rc_subcat);
            headerContent =  view.findViewById(R.id.headerContent);

        }
    }

    public PartVidetextAdapter(ArrayList<MainDataRespose> transactionsList, Context mContext , String response) {

        this.transactionsList = transactionsList;
        this.mContext = mContext;
        this.response = response;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_list_by_adapter, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final MainDataRespose operator = transactionsList.get(position);

        holder.title.setText("" + operator.getHeading());

      /*  Log.e("positionposition","As Top : "+  position );


        if(position==0){

            Log.e("positionposition","As : "+  position );

            holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24));
            holder.rc_subcat.setVisibility(View.VISIBLE);

        }else {

            holder.rc_subcat.setVisibility(View.GONE);
            holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24));

        }*/

        holder.headerContent.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

               /*  Log.e("positionposition","position As :  "+ position);


                 row_index = position;
                 notifyDataSetChanged();*/

                 if(holder.rc_subcat.getVisibility()==View.VISIBLE){
                     holder.rc_subcat.setVisibility(View.GONE);
                     holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24));
                 }else {
                     holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24));
                     holder.rc_subcat.setVisibility(View.VISIBLE);
                 }

                 String Apiresponse="" + new Gson().toJson(operator).toString();
                 Gson gson = new Gson();
                 contenttransactions = gson.fromJson(Apiresponse, MainDataRespose.class);
                 transactionscontent = contenttransactions.getHeadingData();

                 if (transactionscontent.size() > 0) {
                     mAdapter_content = new PartVidetextSubAdapter(transactionscontent, mContext,Apiresponse );
                     holder.rc_subcat.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                     holder.rc_subcat.setItemAnimator(new DefaultItemAnimator());
                     holder.rc_subcat.setAdapter(mAdapter_content);
                     holder.rc_subcat.setNestedScrollingEnabled(false);

                 } else {

                 }
             }
         });


       /* if (row_index == position) {

            holder.imagegetsub.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24));
            holder.rc_subcat.setVisibility(View.VISIBLE);

        } else {



        }*/


    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

}