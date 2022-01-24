package co.jobsearch.Demolms.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.Answer;
import co.jobsearch.Demolms.Utils.Loader;
import co.jobsearch.Demolms.Utils.Question;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.MyViewHolder> {

    private ArrayList<Question> transactionsList;
    private Context mContext;
    public static List<String> imagelist=new ArrayList<>();
    String type="";
    Loader loader;

    ArrayList<Answer> transactionsObjects = new ArrayList<>();
    Question transactions = new Question();

    QuizAnswerAdapter mAdapter;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Questiontext ;
        RecyclerView rv_job_select;


        public MyViewHolder(View view) {
            super(view);
            Questiontext =  view.findViewById(R.id.Question);
            rv_job_select =  view.findViewById(R.id.rv_job_select);


        }
    }

    public QuizAdapter(ArrayList<Question> transactionsList, Context mContext, String type) {

        this.transactionsList = transactionsList;
        this.mContext = mContext;
        this.type = type;

    }

    @Override
    public QuizAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_list_adapter, parent, false);

        return new QuizAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final QuizAdapter.MyViewHolder holder, int position) {
        final Question operator = transactionsList.get(position);

        holder.Questiontext.setText("" + operator.getTitle());


        String response=""+ new Gson().toJson(operator).toString();

        Log.e("Quizresponse","AS : "+  response);

        Gson gson = new Gson();
        transactions = gson.fromJson(response, Question.class);
        transactionsObjects = transactions.getAnswer();

        if (transactionsObjects.size() > 0) {
            mAdapter = new QuizAnswerAdapter(transactionsObjects, mContext);
            holder.rv_job_select.setLayoutManager(new GridLayoutManager(mContext, 1, LinearLayoutManager.VERTICAL, false));
            holder.rv_job_select.setItemAnimator(new DefaultItemAnimator());
            holder.rv_job_select.setAdapter(mAdapter);
            holder.rv_job_select.setNestedScrollingEnabled(false);
            mAdapter.notifyDataSetChanged();
            holder.rv_job_select.setVisibility(View.VISIBLE);


        } else {

            holder.rv_job_select.setVisibility(View.GONE);

        }






    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

}
