package co.jobsearch.Demolms.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.jobsearch.Demolms.Activity.QuizActivity;
import co.jobsearch.Demolms.R;
import co.jobsearch.Demolms.Utils.Answer;

public class QuizAnswerAdapter extends RecyclerView.Adapter<QuizAnswerAdapter.MyViewHolder> {

    private ArrayList<Answer> transactionsList;
    private Context mContext;
    private int row_index=111;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView QuestionAnswer ;
        CheckBox Check_ck;

        public MyViewHolder(View view) {
            super(view);

            QuestionAnswer =  view.findViewById(R.id.QuestionAnswer);
            Check_ck =  view.findViewById(R.id.Check_ck);

        }
    }

    public QuizAnswerAdapter(ArrayList<Answer> transactionsList, Context mContext ) {

        this.transactionsList = transactionsList;
        this.mContext = mContext;

    }

    @Override
    public QuizAnswerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_quiz_list_adapter, parent, false);

        return new QuizAnswerAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final QuizAnswerAdapter.MyViewHolder holder, final int position) {
        final Answer operator = transactionsList.get(position);

        holder.QuestionAnswer.setText("" + operator.getTitle());

        holder.Check_ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();

                ((QuizActivity) mContext).ItemClick(operator.getQuestionId()+"",""+operator.getId() );


            }
        });


        if (row_index == position) {

            holder.Check_ck.setChecked(true);


        } else {

            holder.Check_ck.setChecked(false);

        }




    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

}